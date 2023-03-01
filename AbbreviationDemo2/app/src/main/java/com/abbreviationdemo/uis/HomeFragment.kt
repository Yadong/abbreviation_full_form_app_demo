package com.abbreviationdemo.uis

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.abbreviationdemo.AbbreviationDemoApp
import com.abbreviationdemo.R
import com.abbreviationdemo.ViewModelFactory
import com.abbreviationdemo.adapters.HomeAdapter
import com.abbreviationdemo.databinding.FragmentHomeBinding
import com.abbreviationdemo.extensions.isNetworkConnected
import com.abbreviationdemo.viewmodels.HomeViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeActivity: HomeActivity
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private var disposable: Disposable? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        homeActivity = context as HomeActivity
        (activity?.application as AbbreviationDemoApp).component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = ViewModelProvider(homeActivity, viewModelFactory)[HomeViewModel::class.java]
        homeAdapter = HomeAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = homeAdapter

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.submit.setOnClickListener {
            if (homeActivity.isNetworkConnected().not()) {
                binding.homeNetworkError.root.isVisible = true
                binding.homeNetworkError.buttonRetry.setOnClickListener {
                    getFullForms()
                }
            } else {
                getFullForms()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        disposable?.dispose()
    }

    private fun getFullForms() {
        binding.homeNetworkError.root.isVisible = false
        disposable?.dispose()
        disposable = homeViewModel.getFullFormsSingle(binding.input.text.toString())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onError = { onError(it) }) {
                homeAdapter.mutableList.clear()
                binding.homeError.root.isVisible = false
                if (it.isEmpty().not()) {
                    homeAdapter.mutableList.addAll(it[0].list)
                    homeAdapter.notifyDataSetChanged()
                } else {
                    homeAdapter.notifyDataSetChanged()
                }
            }
    }

    private fun onError(throwable: Throwable) {
        Log.e(LOG_TAG, "failed to get list", throwable)
        binding.homeError.root.isVisible = true
        binding.homeError.buttonRetry.setOnClickListener {
            getFullForms()
        }
    }

    companion object {
        private val LOG_TAG = HomeFragment::class.simpleName!!
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}

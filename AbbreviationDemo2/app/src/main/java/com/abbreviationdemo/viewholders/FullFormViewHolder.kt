package com.abbreviationdemo.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.abbreviationdemo.databinding.FullFormItemBinding
import com.abbreviationdemo.models.FullForm

class FullFormViewHolder(view: View): ViewHolder(view) {

    private val binding: FullFormItemBinding = FullFormItemBinding.bind(view)
    fun bind(fullForm: FullForm) {
        binding.lf.text = fullForm.lf
        binding.freq.text = fullForm.freq.toString()
        binding.since.text = fullForm.year
    }
}

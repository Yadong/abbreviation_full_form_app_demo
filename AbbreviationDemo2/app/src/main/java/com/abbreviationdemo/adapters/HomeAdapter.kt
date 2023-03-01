package com.abbreviationdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abbreviationdemo.R
import com.abbreviationdemo.models.FullForm
import com.abbreviationdemo.viewholders.FullFormViewHolder

class HomeAdapter(val mutableList: MutableList<FullForm> = mutableListOf()) :
    RecyclerView.Adapter<FullFormViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FullFormViewHolder {
        return FullFormViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.full_form_item, parent, false
            )
        )
    }

    override fun getItemCount(): Int = mutableList.size

    override fun onBindViewHolder(holder: FullFormViewHolder, position: Int) {
        holder.bind(mutableList[position])
    }
}

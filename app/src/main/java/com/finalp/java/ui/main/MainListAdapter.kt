package com.finalp.java.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.finalp.java.R
import com.finalp.java.databinding.ListitemMainBinding
import com.finalp.java.model.Contact


/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */

class MainListAdapter(val context: Context, var data: List<Contact>) : RecyclerView.Adapter<MainListItemViewHolder>(){
    private var inflater: LayoutInflater? = null
    init {
        inflater = LayoutInflater.from(context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListItemViewHolder {
        val binding: ListitemMainBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.listitem_main,parent,false)
        return MainListItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MainListItemViewHolder, position: Int) {
        val itemdata = data[position]
        holder.bind(itemdata)
    }

    fun updateData(data:List<Contact>){
        this.data = data
        notifyDataSetChanged()
    }

}

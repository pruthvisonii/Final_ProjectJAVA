package com.finalp.java.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.finalp.java.databinding.ListitemMainBinding
import com.finalp.java.model.Contact
import com.finalp.java.utils.getParentActivity

/**
 * Final Java 1001 Group - A00262875- Pruthvi - A00262877 - Sakshi
 */

class MainListItemViewHolder(var binding: ListitemMainBinding) : RecyclerView.ViewHolder(binding.root) {

    private val viewModel: MainListItemViewModel = MainListItemViewModel(binding.root.getParentActivity() as MainActivity)

    fun bind(contact: Contact){
        viewModel.bind(contact)
        binding.viewModel = viewModel
    }
}

package com.xpns.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.xpns.databinding.ItemSearchBinding


class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {
    var categoryList = arrayOf("Food Drinks", "Health/medical", "Clothes shoes", "Transportation", "Gifts", "Utilities", "Travel", "Debt", "Other", "Housing", "Investments")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val viewModel = ViewModelProviders.of(parent.context as SearchActivity).get(SearchViewModel::class.java)
        return SearchViewHolder(ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false), viewModel)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val category = categoryList[position]
        holder.bind(category)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    inner class SearchViewHolder(private val binding: ItemSearchBinding, val viewModel: SearchViewModel) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: String) {
            binding.category = category
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }
}

package com.xpns.ui.search

import androidx.databinding.DataBindingUtil
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xpns.R
import com.xpns.data.model.Item
import com.xpns.databinding.ItemSearchBinding

class SearchAdapter(private var repositories: List<Item>,
                    private val eventHandler: SearchEventHandler) : androidx.recyclerview.widget.RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    fun updateData(repositories: List<Item>) {
        Log.d("=====", "===" + repositories.size)
        this.repositories = repositories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val bindings: ItemSearchBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_search, parent, false)
        return SearchViewHolder(bindings)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val repository = repositories[position]
        holder.bind(repository, eventHandler)
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    inner class SearchViewHolder(private val binding: ItemSearchBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: Item, eventHandler: SearchEventHandler) {
            binding.repositoryModel = repository
            binding.eventHandler = eventHandler
            binding.executePendingBindings()
        }
    }
}

package com.xpns.ui.search

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xpns.R
import com.xpns.data.model.Item

class SearchAdapter(private var repositories: List<Item>,
                    private val eventHandler: SearchEventHandler) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    fun updateData(repositories: List<Item>) {
        Log.d("=====", "===" + repositories.size)
        this.repositories = repositories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val bindings: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
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

    inner class SearchViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: Item, eventHandler: SearchEventHandler) {
//            binding.repositoryModel = repository
//            binding.eventHandler = eventHandler
            binding.executePendingBindings()
        }
    }
}

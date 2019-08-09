package com.hush.ui.hushlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hush.data.model.Portfolio
import com.hush.databinding.ItemHushBinding

class HushListAdapter(private var portfolioList: List<Portfolio>) : RecyclerView.Adapter<HushListAdapter.DetailViewHolder>() {

    fun updateData(repositories: List<Portfolio>) {
        this.portfolioList = repositories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val bindings: ItemHushBinding = ItemHushBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(bindings)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = portfolioList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return portfolioList.size
    }

    inner class DetailViewHolder(private val binding: ItemHushBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(portfolio: Portfolio) {
            binding.viewModel = portfolio
            binding.executePendingBindings()
        }
    }
}

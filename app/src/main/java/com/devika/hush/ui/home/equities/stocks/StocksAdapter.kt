package com.devika.hush.ui.home.equities.stocks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.data.model.Stock
import com.devika.hush.databinding.StocksItemListBinding

class StocksAdapter : ListAdapter<Stock, StocksAdapter.StocksViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksViewHolder =
        StocksViewHolder(
            StocksItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: StocksViewHolder, position: Int) {
        val stock = getItem(position)
        holder.bind(stock)
    }

    inner class StocksViewHolder(private val binding: StocksItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(stock: Stock?) {
            binding.stock = stock
        }
    }
}

private val DIFF_CALLBACK: DiffUtil.ItemCallback<Stock> =
    object : DiffUtil.ItemCallback<Stock>() {

        override fun areItemsTheSame(oldItem: Stock, newItem: Stock): Boolean =
            oldItem.symbol == newItem.symbol

        override fun areContentsTheSame(oldItem: Stock, newItem: Stock): Boolean =
            oldItem == newItem
    }

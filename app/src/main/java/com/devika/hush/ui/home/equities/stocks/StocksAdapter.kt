package com.devika.hush.ui.home.equities.stocks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.data.model.Stock
import com.devika.hush.databinding.ItemStocksBinding
import com.devika.hush.ui.home.equities.ItemClickListener

class StocksAdapter(val itemClickListener :ItemClickListener)  : ListAdapter<Stock, StocksAdapter.StocksViewHolder>(DIFF_CALLBACK) ,Filterable{

    val stockList = mutableListOf<Stock>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksViewHolder =
        StocksViewHolder(
            ItemStocksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: StocksViewHolder, position: Int) {
        val stock = getItem(position)
        holder.bind(stock)
    }
    override fun getFilter(): Filter = object : Filter() {
        val filterResults = FilterResults()
        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            val filterList = mutableListOf<Stock>()
            if (charSequence.toString().isEmpty()) {
                submitList(null)
                filterList.addAll(stockList)
            } else {
                for (item in stockList) {
                    if (item.symbol.toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                        filterList.add(item)
                    }
                }
            }
            filterResults.values = filterList
            return filterResults
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            submitList(filterResults.values as MutableList<Stock>?)
            notifyDataSetChanged()
        }

    }

    override fun submitList(list: List<Stock>?) {
        if (stockList.isEmpty()) {
            this.stockList.addAll(list as MutableList<Stock>)
        }
        super.submitList(list)
    }

    inner class StocksViewHolder(private val binding: ItemStocksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(stock: Stock?) {
            binding.stock = stock
            binding.itemClickListener = itemClickListener
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

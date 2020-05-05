package com.devika.hush.ui.home.equities.watchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.data.model.DetailWatchList
import com.devika.hush.databinding.ItemWatchlistBinding
import com.devika.hush.ui.home.equities.ItemClickListener

class WatchListAdapter(private val itemClickListener: ItemClickListener) :
    ListAdapter<DetailWatchList, WatchListAdapter.WatchListViewHolder>(DIFF_CALLBACK), Filterable {

    val watchList = mutableListOf<DetailWatchList>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchListViewHolder {
        val binding =
            ItemWatchlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WatchListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WatchListViewHolder, position: Int) {
        val watchList = getItem(position)
        holder.setData(watchList)
    }

    override fun getFilter(): Filter = object : Filter() {
        val filterResults = FilterResults()
        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            val filterList = mutableListOf<DetailWatchList>()
            if (charSequence.toString().isEmpty()) {
                submitList(null)
                filterList.addAll(watchList)
            } else {
                for (item in watchList) {
                    if (item.watchList.symbol.toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                        filterList.add(item)
                    }
                }
            }
            filterResults.values = filterList
            return filterResults
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            submitList(filterResults.values as MutableList<DetailWatchList>?)
            notifyDataSetChanged()
        }
    }

    override fun submitList(list: List<DetailWatchList>?) {
        if (watchList.isEmpty()) {
            this.watchList.addAll(list as MutableList<DetailWatchList>)
        }
        super.submitList(list)
    }

    inner class WatchListViewHolder(private val binding: ItemWatchlistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(watchList: DetailWatchList) {
            binding.watchList = watchList
            binding.itemClickListener = itemClickListener
        }
    }
}

val DIFF_CALLBACK: DiffUtil.ItemCallback<DetailWatchList> =
    object : DiffUtil.ItemCallback<DetailWatchList>() {
        override fun areItemsTheSame(oldItem: DetailWatchList, newItem: DetailWatchList): Boolean =
            oldItem.watchList.symbol == newItem.watchList.symbol

        override fun areContentsTheSame(
            oldItem: DetailWatchList,
            newItem: DetailWatchList
        ): Boolean = oldItem == newItem
    }

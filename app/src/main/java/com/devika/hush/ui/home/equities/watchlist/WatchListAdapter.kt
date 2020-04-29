package com.devika.hush.ui.home.equities.watchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.data.model.DetailWatchList
import com.devika.hush.databinding.WatchlistItemListBinding

class WatchListAdapter :
    ListAdapter<DetailWatchList, WatchListAdapter.WatchListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchListViewHolder {
        val binding =
            WatchlistItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WatchListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WatchListViewHolder, position: Int) {
        val watchList = getItem(position)
        holder.setData(watchList)
    }

    inner class WatchListViewHolder(private val binding: WatchlistItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(watchList: DetailWatchList) {
            binding.watchList = watchList
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

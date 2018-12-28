package com.xpns.ui.detail

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xpns.R
import com.xpns.data.model.Subscribers
import com.xpns.databinding.ItemDetailBinding

class DetailAdapter(private var subscribers: List<Subscribers>) : androidx.recyclerview.widget.RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    fun updateData(repositories: List<Subscribers>) {
        this.subscribers = repositories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val bindings: ItemDetailBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_detail, parent, false)
        return DetailViewHolder(bindings)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val subscriber = subscribers[position]
        holder.bind(subscriber)
    }

    override fun getItemCount(): Int {
        return subscribers.size
    }

    inner class DetailViewHolder(private val binding: ItemDetailBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
        fun bind(subscribers: Subscribers) {
            binding.subscriberModel = subscribers
            binding.executePendingBindings()
        }
    }
}

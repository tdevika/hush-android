package com.hush.ui.hushlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hush.data.model.Hush
import com.hush.databinding.ItemHushBinding

class HushListAdapter(private var xpns: List<Hush>) : RecyclerView.Adapter<HushListAdapter.DetailViewHolder>() {

    fun updateData(repositories: List<Hush>) {
        this.xpns = repositories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val bindings: ItemHushBinding = ItemHushBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(bindings)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = xpns[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return xpns.size
    }

    inner class DetailViewHolder(private val binding: ItemHushBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hush: Hush) {
            binding.viewModel = hush
            binding.executePendingBindings()
        }
    }
}

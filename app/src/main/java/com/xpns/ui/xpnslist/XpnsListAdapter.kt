package com.xpns.ui.xpnslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.xpns.R
import com.xpns.data.model.Xpns
import com.xpns.databinding.ItemXpnsBinding

class XpnsListAdapter(private var xpns: List<Xpns>) : RecyclerView.Adapter<XpnsListAdapter.DetailViewHolder>() {

  fun updateData(repositories: List<Xpns>) {
    this.xpns = repositories
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
    val bindings: ItemXpnsBinding = ItemXpnsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return DetailViewHolder(bindings)
  }

  override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
    val item = xpns[position]
    holder.bind(item)
  }

  override fun getItemCount(): Int {
    return xpns.size
  }

  inner class DetailViewHolder(private val binding: ItemXpnsBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(xpns: Xpns) {
      binding.viewModel = xpns
      binding.executePendingBindings()
    }
  }
}

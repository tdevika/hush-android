package com.devika.hush.ui.home.equities.portfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.data.model.Portfolio
import com.devika.hush.databinding.ItemPortfolioBinding
import java.util.concurrent.Executors

class PortfolioAdapter : ListAdapter<Portfolio, PortfolioViewHolder>(
    AsyncDifferConfig.Builder(PortfolioDiff)
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder = PortfolioViewHolder(
        ItemPortfolioBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class PortfolioViewHolder(
    private val binding: ItemPortfolioBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(portfolio: Portfolio) {
        binding.portfolio = portfolio
        binding.executePendingBindings()
    }
}

object PortfolioDiff : DiffUtil.ItemCallback<Portfolio>() {
    override fun areItemsTheSame(oldItem: Portfolio, newItem: Portfolio): Boolean =
        oldItem.symbol == newItem.symbol

    override fun areContentsTheSame(oldItem: Portfolio, newItem: Portfolio): Boolean =
        oldItem == newItem
}

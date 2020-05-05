package com.devika.hush.ui.home.equities.portfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
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
), Filterable {

    val portfolioList: MutableList<Portfolio> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder =
        PortfolioViewHolder(
            ItemPortfolioBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) =
        holder.bind(getItem(position))

    override fun getFilter(): Filter = object : Filter() {
        val filterResults = FilterResults()
        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            val filterList = mutableListOf<Portfolio>()
            if (charSequence.toString().isEmpty()) {
                submitList(null)
                filterList.addAll(portfolioList)
            } else {
                for (item in portfolioList) {
                    if (item.symbol.toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                        filterList.add(item)
                    }
                }
            }
            filterResults.values = filterList
            return filterResults
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            submitList(filterResults.values as MutableList<Portfolio>?)
            notifyDataSetChanged()
        }
    }

    override fun submitList(list: List<Portfolio>?) {
        if (portfolioList.isEmpty()) {
            this.portfolioList.addAll(list as MutableList<Portfolio>)
        }
        super.submitList(list)
    }
}

class PortfolioViewHolder(
    private val binding: ItemPortfolioBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(portfolio: Portfolio) {
        binding.portfolio = portfolio
    }
}

object PortfolioDiff : DiffUtil.ItemCallback<Portfolio>() {
    override fun areItemsTheSame(oldItem: Portfolio, newItem: Portfolio): Boolean =
        oldItem.symbol == newItem.symbol

    override fun areContentsTheSame(oldItem: Portfolio, newItem: Portfolio): Boolean =
        oldItem == newItem
}

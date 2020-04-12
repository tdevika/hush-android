package com.devika.hush.ui.portfolio

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.R
import com.devika.hush.data.model.Portfolio
import kotlinx.android.synthetic.main.portfolio_item_list.view.*
import java.text.DecimalFormat
import javax.inject.Inject


class PortfolioAdapter @Inject constructor() :
    ListAdapter<Portfolio, PortfolioAdapter.PortfolioViewHolder>(DIFF_CALLBACK), Filterable {

    private var portfolioList: ArrayList<Portfolio> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.portfolio_item_list, parent, false)
        return PortfolioViewHolder(view)
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        val stocks = getItem(position)
        holder.setData(stocks)
    }

    override fun submitList(list: MutableList<Portfolio>?) {
        if (portfolioList.isEmpty()) {
            this.portfolioList.addAll(list as ArrayList<Portfolio>)
        }
        super.submitList(list)
    }

    override fun getFilter() = object : Filter() {
        val filterResults = FilterResults()

        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            val filterList = ArrayList<Portfolio>()
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

    inner class PortfolioViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding.rootView) {
        fun setData(stocks: Portfolio) {
            with(binding) {
                setUI(stocks)
            }
        }

        private fun View.setUI(stocks: Portfolio) {
            val formate = DecimalFormat("00.00")
            symbol.text = stocks.symbol
            closePrice.text = "Ltp: ${stocks.closePrice}"
            sector.text = stocks.sector
            average.text = "Avg: ${stocks.avgCost}"
            highValue.text = "H: ${stocks.hi52Wk}"
            lowValue.text = "L: ${stocks.lo52Wk}"
            quantity.text = "Qty: ${stocks.quantity}"

            dayChangePercentage.text = formate.format(stocks.dayChangePercentage()) + "%"

            if (stocks.dayChange() < 0) {
                dayChangePercentage.setTextColor(Color.RED)
                //icon.setImageResource(R.drawable.ic_arrow_drop_down)
            } else {
                dayChangePercentage.setTextColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.colorPrimary,
                        null
                    )
                )
                // icon.setImageResource(R.drawable.ic_arrow_drop_up)
            }
            netChangePercentage.text = formate.format(stocks.netChangePercentage()) + "%"

            if (stocks.netChangePercentage() < 0) {
                netChangePercentage.setTextColor(Color.RED)
            } else {
                netChangePercentage.setTextColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.colorPrimary,
                        null
                    )
                )
            }
        }
    }
}

private val DIFF_CALLBACK: DiffUtil.ItemCallback<Portfolio> =
    object : DiffUtil.ItemCallback<Portfolio>() {

        override fun areItemsTheSame(oldItem: Portfolio, newItem: Portfolio): Boolean =
            oldItem.symbol == newItem.symbol

        override fun areContentsTheSame(oldItem: Portfolio, newItem: Portfolio): Boolean =
            oldItem == newItem
    }




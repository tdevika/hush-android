package com.devika.hush.ui.portfolio

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.R
import com.devika.hush.data.model.Stocks
import kotlinx.android.synthetic.main.portfolio_item_list.view.*
import java.text.DecimalFormat
import javax.inject.Inject

class PortfolioListAdapter @Inject constructor() :
    RecyclerView.Adapter<PortfolioListAdapter.PortfolioViewHolder>(), Filterable {

    private var portfolioList: ArrayList<Stocks> = arrayListOf()
    private var searchPortfolioList: ArrayList<Stocks> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioViewHolder {
        var binding =
            LayoutInflater.from(parent.context).inflate(R.layout.portfolio_item_list, parent, false)
        return PortfolioViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return searchPortfolioList.size
    }

    override fun onBindViewHolder(holder: PortfolioViewHolder, position: Int) {
        val stocks = searchPortfolioList[position]
        holder.setData(stocks)
    }

    override fun getFilter() = object : Filter() {
        val filterResults = FilterResults()

        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            val filterList = ArrayList<Stocks>()
            if (charSequence.toString().isEmpty()) {
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
            searchPortfolioList.clear()
            searchPortfolioList.addAll(filterResults.values as Collection<Stocks>)
            notifyDataSetChanged()
        }

    }

    fun updateData(portfolioList: ArrayList<Stocks>) {
        this.portfolioList = portfolioList
        this.searchPortfolioList.addAll(portfolioList)
        notifyDataSetChanged()
    }

    inner class PortfolioViewHolder(val binding: View) : RecyclerView.ViewHolder(binding.rootView) {
        fun setData(stocks: Stocks) {
            with(binding) {
                setUI(stocks)
            }
        }

        private fun View.setUI(stocks: Stocks) {

            symbol.text = stocks.symbol
            close_price.text = "Ltp: ${stocks.closePrice}"
            sector.text = stocks.sector
            average.text = "Avg: ${stocks.avgCost}"
            high_value.text = "H: ${stocks.hi52Wk}"
            low_value.text = "L: ${stocks.lo52Wk}"
            quantity.text = "Qty: ${stocks.quantity}"

            dayChangePercentage.text = stocks.dayChangePercentage().toString() + "%"

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
            net_change_percentage.text = stocks.netChangePercentage().toString()+"%"

            if (stocks.netChangePercentage() < 0) {
                net_change_percentage.setTextColor(Color.RED)
            } else {
                net_change_percentage.setTextColor(
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
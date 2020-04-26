package com.devika.hush.ui.home.equities.stocks

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.R
import com.devika.hush.data.model.Stock
import kotlinx.android.synthetic.main.item_portfolio.view.symbol
import kotlinx.android.synthetic.main.stocks_item_list.view.*

class StocksAdapter(
    val stockList: ArrayList<Stock>,
    val longPress: (Stock) -> Unit
) :
    ListAdapter<Stock, StocksAdapter.StocksViewHolder>(DIFF_CALLBACK), Filterable {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.stocks_item_list, parent, false)
        return StocksViewHolder(view)
    }

    override fun onBindViewHolder(holder: StocksViewHolder, position: Int) {
        val stocks = getItem(position)
        holder.setData(stocks)
    }

    override fun getFilter() = object : Filter() {
        var filterResult = FilterResults()
        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            val searchFilterList = ArrayList<Stock>()
            if (charSequence.toString().isEmpty()) {
                submitList(null)
                searchFilterList.addAll(stockList)
            } else {
                for (stock in stockList) {
                    if (stock.symbol.toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                        searchFilterList.add(stock)
                    }
                }
            }

            filterResult.values = searchFilterList
            return filterResult
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            submitList(filterResult.values as MutableList<Stock>?)
        }
    }

    override fun submitList(list: MutableList<Stock>?) {
        if (stockList.isEmpty()) {
            this.stockList.addAll(list as ArrayList<Stock>)
        }
        super.submitList(list)
    }

    inner class StocksViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding.rootView) {

        fun setData(
            stock: Stock
        ) {
            with(binding) {
                setOnLongClickListener() {
                    showDialog(stock)
                    true
                }
                setUI(stock)
            }
        }

        private fun View.setUI(stock: Stock) {
            security.text = stock.security
            symbol.text = stock.symbol
            closePrice.text = stock.closePrice
            index.text = stock.index
            highValue.text = stock.hi52Wk
            lowValue.text = stock.lo52Wk
            dayChange.text = "${stock.dayChange()}  "
            if (stock.dayChange() < 0) {
                dayChange.setTextColor(Color.RED)
            } else {
                dayChange.setTextColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.colorPrimary,
                        null
                    )
                )
            }
            dayChangePercentage.text = "${stock.dayChangePercentage()}%"

            if (stock.dayChange() < 0) {
                dayChangePercentage.setTextColor(Color.RED)
                icon.setImageResource(R.drawable.ic_arrow_drop_down)
            } else {
                dayChangePercentage.setTextColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.colorPrimary,
                        null
                    )
                )
                icon.setImageResource(R.drawable.ic_arrow_drop_up)
            }
        }

        private fun View.showDialog(stock: Stock) {

            if (!stock.isStockAddedToWatchList) {
                AlertDialog.Builder(context)
                    // .setTitle("Add to WatchList")
                    .setMessage("Add to WatchList")
                    .setPositiveButton("Ok") { a: DialogInterface, b: Int ->
                        longPress(stock)
                    }
                    .setNegativeButton("Cancel") { dialogInterface: DialogInterface, i: Int -> }
                    .show()
            } else {
                Toast.makeText(context, "Already Added to WatchList", Toast.LENGTH_LONG).show()
            }
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

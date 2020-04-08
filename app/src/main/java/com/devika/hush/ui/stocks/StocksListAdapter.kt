package com.devika.hush.ui.stocks

import android.app.AlertDialog
import android.content.DialogInterface
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
import kotlinx.android.synthetic.main.portfolio_item_list.view.close_price
import kotlinx.android.synthetic.main.portfolio_item_list.view.high_value
import kotlinx.android.synthetic.main.portfolio_item_list.view.low_value
import kotlinx.android.synthetic.main.portfolio_item_list.view.symbol
import kotlinx.android.synthetic.main.stocks_item_list.view.*
import javax.inject.Inject

class StocksListAdapter @Inject constructor() :
    RecyclerView.Adapter<StocksListAdapter.StocksViewHolder>(), Filterable {

    private var stockList: ArrayList<Stocks> = arrayListOf()
    private var searchList: ArrayList<Stocks> = arrayListOf()
    private lateinit var longPressHandler: (Stocks) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksViewHolder {
        val binding =
            LayoutInflater.from(parent.context).inflate(R.layout.stocks_item_list, parent, false)
        return StocksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StocksViewHolder, position: Int) {
        val stocks = searchList[position]
        holder.setData(stocks)
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    override fun getFilter() = object : Filter() {
        var filterResult = FilterResults()
        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            val searchFilterList = ArrayList<Stocks>()
            if (charSequence.toString().isEmpty()) {
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
            searchList.clear()
            searchList.addAll(filterResult.values as Collection<Stocks>)
            notifyDataSetChanged()
        }

    }


    fun updateData(
        stocksList: ArrayList<Stocks>,
        longPress: (Stocks) -> Unit
    ) {
        this.longPressHandler = longPress
        this.searchList.addAll(stocksList)
        this.stockList = stocksList
        notifyDataSetChanged()
    }

    inner class StocksViewHolder(private val binding: View) :
        RecyclerView.ViewHolder(binding.rootView) {

        fun setData(
            stocks: Stocks
        ) {
            with(binding) {
                setOnLongClickListener() {
                    showDialog(stocks)
                    true
                }
                setUI(stocks)
            }
        }

        private fun View.setUI(stocks: Stocks) {
            security.text = stocks.security
            symbol.text = stocks.symbol
            close_price.text = stocks.closePrice
            index.text = stocks.index
            high_value.text = stocks.hi52Wk
            low_value.text = stocks.lo52Wk
            price_difference.text = stocks.dayChange().toString()
            if (stocks.dayChange() < 0) {
                price_difference.setTextColor(Color.RED)
            } else {
                price_difference.setTextColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.colorPrimary,
                        null
                    )
                )
            }
            price_difference_percentage.text = "${stocks.dayChangePercentage()}%"

            if (stocks.dayChange() < 0) {
                price_difference_percentage.setTextColor(Color.RED)
                icon.setImageResource(R.drawable.ic_arrow_drop_down)
            } else {
                price_difference_percentage.setTextColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.colorPrimary,
                        null
                    )
                )
                icon.setImageResource(R.drawable.ic_arrow_drop_up)
            }
        }

        private fun View.showDialog(stocks: Stocks) {
            if (!stocks.isStockAddedToWatchList) {
                AlertDialog.Builder(context)
                    //.setTitle("Add to WatchList")
                    .setMessage("Add to WatchList")
                    .setPositiveButton("Ok") { a: DialogInterface, b: Int ->
                        longPressHandler(stocks)
                    }
                    .setNegativeButton("Cancel") { dialogInterface: DialogInterface, i: Int -> }
                    .show()
            } else {
                AlertDialog.Builder(context)
                    //.setTitle("Add to WatchList")
                    .setMessage("Already Added to WatchList")
                    .setPositiveButton("Ok") { a: DialogInterface, b: Int ->
                    }
                    .show()
            }
        }

    }


}
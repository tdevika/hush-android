package com.devika.hush.ui.watchlist

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.R
import com.devika.hush.data.model.Stocks
import kotlinx.android.synthetic.main.portfolio_item_list.view.symbol
import kotlinx.android.synthetic.main.watchlist_item_list.view.*
import javax.inject.Inject

class WatchListAdapter @Inject constructor() :
    RecyclerView.Adapter<WatchListAdapter.WatchListViewHolder>(), Filterable {

    var stocks: ArrayList<Stocks> = arrayListOf()
    var searchList: ArrayList<Stocks> = arrayListOf()
    lateinit var longPress: (Stocks) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchListViewHolder {
        val binding =
            LayoutInflater.from(parent.context).inflate(R.layout.watchlist_item_list, parent, false)
        return WatchListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    override fun onBindViewHolder(holder: WatchListViewHolder, position: Int) {
        var stocks = searchList[position]
        stocks?.let { holder.setData(it) }
    }

    override fun getFilter(): Filter = searchingStocks()

    private fun searchingStocks(): Filter {
        return object : Filter() {
            val filterResults = FilterResults()
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val filterList: ArrayList<Stocks> = arrayListOf()
                if (p0.isNullOrEmpty()) {
                    filterList.addAll(stocks)
                } else {
                    for (stock in stocks) {
                        if (stock.symbol.toLowerCase().startsWith(p0.toString().toLowerCase())) {
                            filterList.add(stock)
                        }
                    }
                }
                filterResults.values = filterList
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                searchList.clear()
                searchList.addAll(filterResults.values as Collection<Stocks>)
                notifyDataSetChanged()
            }

        }
    }

    fun updateData(
        stocks: ArrayList<Stocks>,
        longPress: (Stocks) -> Unit
    ) {
        this.stocks = stocks
        this.longPress = longPress
        this.searchList.addAll(stocks)
        notifyDataSetChanged()
    }

    inner class WatchListViewHolder(val binding: View) : RecyclerView.ViewHolder(binding.rootView) {
        fun setData(stocks: Stocks) {
            with(binding) {
                setUI(stocks)
                setOnLongClickListener() {
                    setAlertDialog(stocks)
                    true
                }
            }

        }

        private fun View.setUI(stocks: Stocks) {
            symbol.text = stocks.symbol
            closePrice.text = stocks.price
            date.text = stocks.date
        }

    }

    private fun View.setAlertDialog(stocks: Stocks): AlertDialog? {
        return AlertDialog.Builder(context)
            .setTitle("Delete From WatchList")
            .setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->
                longPress(stocks)
            }
            .setNegativeButton("Cancel") { dialogInterface: DialogInterface, i: Int -> }
            .show()
    }


}
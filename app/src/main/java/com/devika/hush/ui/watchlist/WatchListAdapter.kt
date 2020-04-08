package com.devika.hush.ui.watchlist

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devika.hush.R
import com.devika.hush.data.model.Stocks
import kotlinx.android.synthetic.main.portfolio_item_list.view.symbol
import kotlinx.android.synthetic.main.watchlist_item_list.view.*
import javax.inject.Inject

class WatchListAdapter @Inject constructor() :
    RecyclerView.Adapter<WatchListAdapter.WatchListViewHolder>() {

    var stocks: List<Stocks> = emptyList()
    lateinit var longPress: (Stocks) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchListViewHolder {
        val binding =
            LayoutInflater.from(parent.context).inflate(R.layout.watchlist_item_list, parent, false)
        return WatchListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return stocks.size
    }

    override fun onBindViewHolder(holder: WatchListViewHolder, position: Int) {
        var stocks = stocks[position]
        holder.setData(stocks)
    }

    fun updateData(
        stocks: List<Stocks>,
        longPress: (Stocks) -> Unit
    ) {
        this.stocks = stocks
        this.longPress = longPress
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
            price.text = stocks.closePrice
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
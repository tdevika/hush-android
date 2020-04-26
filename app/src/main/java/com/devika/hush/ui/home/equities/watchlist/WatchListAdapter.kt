package com.devika.hush.ui.home.equities.watchlist

import android.app.AlertDialog
import android.content.DialogInterface
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
import com.devika.hush.data.model.DetailWatchList
import kotlinx.android.synthetic.main.item_portfolio.view.symbol
import kotlinx.android.synthetic.main.watchlist_item_list.view.*
import kotlinx.android.synthetic.main.watchlist_item_list.view.closePrice
import kotlinx.android.synthetic.main.watchlist_item_list.view.dayChangePercentage
import kotlinx.android.synthetic.main.watchlist_item_list.view.highValue
import kotlinx.android.synthetic.main.watchlist_item_list.view.lowValue

class WatchListAdapter(
    var detailWatchList: ArrayList<DetailWatchList>,
    var longPress: (DetailWatchList) -> Unit
) :
    ListAdapter<DetailWatchList,WatchListAdapter.WatchListViewHolder>(DIFF_CALLBACK), Filterable {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchListViewHolder {
        val binding =
            LayoutInflater.from(parent.context).inflate(R.layout.watchlist_item_list, parent, false)
        return WatchListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WatchListViewHolder, position: Int) {
        var stocks = getItem(position)
        stocks?.let { holder.setData(it) }
    }

    override fun submitList(list: MutableList<DetailWatchList>?) {
        super.submitList(list)
        if(detailWatchList.isEmpty()){
            detailWatchList.addAll(list as ArrayList)
        }
    }

    override fun getFilter(): Filter = searchingStocks()

    private fun searchingStocks(): Filter {
        return object : Filter() {
            val filterResults = FilterResults()
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val filterListDetail: ArrayList<DetailWatchList> = arrayListOf()
                if (p0.isNullOrEmpty()) {
                    submitList(null)
                    filterListDetail.addAll(detailWatchList)
                } else {
                    for (stock in detailWatchList) {
                        if (stock.watchList.symbol.toLowerCase().startsWith(p0.toString().toLowerCase())) {
                            filterListDetail.add(stock)
                        }
                    }
                }
                filterResults.values = filterListDetail
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {

                submitList((filterResults.values as MutableList<DetailWatchList>?))

            }

        }
    }

    inner class WatchListViewHolder(private val view: View) :
        RecyclerView.ViewHolder(view.rootView) {
        fun setData(stock: DetailWatchList) {
            with(view) {
                setUI(stock)
                setOnLongClickListener() {
                    setAlertDialog(stock)
                    true
                }
            }

        }

        private fun View.setUI(detailWatchList: DetailWatchList) {
            symbol.text = detailWatchList.watchList.symbol
            price.text = "added " + detailWatchList.watchList.price
            date.text = " on " + detailWatchList.watchList.date
            highValue.text = detailWatchList.stock.hi52Wk
            lowValue.text = detailWatchList.stock.lo52Wk
            closePrice.text = detailWatchList.stock.closePrice
            dayChange.text = "${detailWatchList.stock.dayChange().toString()}  "
            if (detailWatchList.stock.dayChange() < 0) {
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
            dayChangePercentage.text = "${detailWatchList.stock.dayChangePercentage()}%"

            if (detailWatchList.stock.dayChange() < 0) {
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
    }


    private fun View.setAlertDialog(detailWatchList: DetailWatchList): AlertDialog? {
        return AlertDialog.Builder(context)
            .setTitle("Delete From WatchList")
            .setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->
                longPress(detailWatchList)
            }
            .setNegativeButton("Cancel") { dialogInterface: DialogInterface, i: Int -> }
            .show()
    }


}

val DIFF_CALLBACK: DiffUtil.ItemCallback<DetailWatchList> =
    object : DiffUtil.ItemCallback<DetailWatchList>() {
        override fun areItemsTheSame(oldItem: DetailWatchList, newItem: DetailWatchList): Boolean =
            oldItem.watchList.symbol == newItem.watchList.symbol

        override fun areContentsTheSame(
            oldItem: DetailWatchList,
            newItem: DetailWatchList
        ): Boolean = oldItem == newItem


    }
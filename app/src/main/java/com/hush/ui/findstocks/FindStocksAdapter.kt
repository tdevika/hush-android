package com.hush.ui.findstocks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.hush.data.model.Portfolio
import com.hush.databinding.StocksListBinding

class FindStocksAdapter(private var stocksList: ArrayList<Portfolio>) :
    RecyclerView.Adapter<FindStocksAdapter.StocksListViewHolder>(), Filterable {
    private var searchList: ArrayList<Portfolio> = arrayListOf()
    fun updateData(repository: ArrayList<Portfolio>) {
        this.stocksList = repository
        searchList.addAll(stocksList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksListViewHolder {
        val bindings = StocksListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StocksListViewHolder(bindings)
    }

    override fun getItemCount(): Int {
        return stocksList.size
    }

    override fun onBindViewHolder(holder: StocksListViewHolder, position: Int) {
        val item = stocksList[position]
        holder.bind(item)
    }


    inner class StocksListViewHolder(private val binding: StocksListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Portfolio) {
            binding.viewModel = item

        }

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterList = ArrayList<Portfolio>()
                if (!constraint.isNullOrEmpty()) {
                    val filterPattern: String = constraint.toString().toLowerCase().trim()
                    searchList.forEach {
                        if (it.security.toLowerCase().startsWith(filterPattern)) {
                            filterList.add(it)
                        }
                    }
                } else {
                    filterList.addAll(searchList)
                }
                val results = FilterResults()
                results.values = filterList
                return results
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults?) {
                results?.values?.let {
                    stocksList.clear()
                    stocksList.addAll(it as ArrayList<Portfolio>)
                    notifyDataSetChanged()

                }
            }
        }


    }

}
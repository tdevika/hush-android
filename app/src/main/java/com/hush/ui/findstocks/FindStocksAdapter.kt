package com.hush.ui.findstocks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hush.data.model.Portfolio
import com.hush.databinding.StocksListBinding

class FindStocksAdapter(private var stocksList:List<Portfolio>):RecyclerView.Adapter<FindStocksAdapter.StocksListViewHolder>() {
fun updateData(repository:List<Portfolio>){
    this.stocksList=repository
    notifyDataSetChanged()

}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksListViewHolder {
     val bindings=StocksListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return StocksListViewHolder(bindings)
    }

    override fun getItemCount(): Int {
        return stocksList.size
    }

    override fun onBindViewHolder(holder: StocksListViewHolder, position: Int) {
 var item=stocksList[position]
        holder.bind(item)
    }


    inner class StocksListViewHolder(private val binding:StocksListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: Portfolio) {
            binding.viewModel=item

        }

    }
}
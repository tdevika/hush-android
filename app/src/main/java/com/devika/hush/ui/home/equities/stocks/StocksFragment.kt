package com.devika.hush.ui.home.equities.stocks

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.data.model.Stock
import com.devika.hush.data.model.WatchList
import com.devika.hush.utils.DateUtils
import com.devika.hush.utils.HushViewModelFactory
import kotlinx.android.synthetic.main.fragment_stocks.*
import java.util.*
import javax.inject.Inject

class StocksFragment : Fragment() {

    @Inject
    lateinit var hushViewModelFactory: HushViewModelFactory

    private lateinit var stocksAdapter: StocksAdapter

    private lateinit var stocksViewModel: StocksViewModel


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_stocks, container, false)
        setHasOptionsMenu(true)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)
        menu.findItem(R.id.filter).isVisible = false
        val menuItem = menu.findItem(R.id.search)
        val searchView = menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                stocksAdapter.filter.filter(newText)
                return false
            }
        })
    }

    private fun initUI() {
        initViewModel()
        initRecyclerView()
    }

    private fun initViewModel() {
        stocksViewModel = ViewModelProvider(this, hushViewModelFactory).get(StocksViewModel::class.java)
        stocksViewModel.stockList.observe(viewLifecycleOwner, Observer {
            progress_bar.visibility = View.INVISIBLE
            it?.let { stocksAdapter.submitList(it as ArrayList<Stock>) }
        })
    }

    private fun initRecyclerView() {
        stocksAdapter = StocksAdapter(arrayListOf(), longPressListener)
        with(recycler) {
            layoutManager = LinearLayoutManager(activity)
            adapter = stocksAdapter
        }
    }

    private val longPressListener = fun(stock: Stock) {
        stocksViewModel.addToWatchList(
            WatchList(
                stock.symbol,
                stock.closePrice,
                DateUtils.getCurrentDate()
            )
        );
        stock.isStockAddedToWatchList = true
    }
}

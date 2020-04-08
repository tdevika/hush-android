package com.devika.hush.ui.watchlist


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.data.model.Stocks
import com.devika.hush.utilities.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_wish_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class WatchListFragment : Fragment() {

    @Inject
    lateinit var watchListAdapter: WatchListAdapter
    @Inject
    lateinit var watchListViewModelFactory: ViewModelFactory

    private lateinit var watchListViewModel: WatchListViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_wish_list, container, false)

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
    }

    private fun initUI() {
        initViewModel()
        initRecyclerView()
    }

    private fun initViewModel() {
        watchListViewModel =
            ViewModelProvider(this, watchListViewModelFactory).get(WatchListViewModel::class.java)

        watchListViewModel.stocks.observe(viewLifecycleOwner, Observer {
            progress_bar.visibility=View.INVISIBLE
            it?.let { watchListAdapter.updateData(it,longPress) }
        })
    }

    private fun initRecyclerView() {
        with(recycler) {
            layoutManager = LinearLayoutManager(activity)
            adapter = watchListAdapter
        }
    }

    private val longPress=fun(stocks: Stocks){
         watchListViewModel.deleteWatchList(stocks)
        stocks.isStockAddedToWatchList=false
    }


}

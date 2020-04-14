package com.devika.hush.ui.portfolio


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.data.model.Portfolio
import com.devika.hush.utilities.HushViewModelFactory
import kotlinx.android.synthetic.main.fragment_portfolio.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class PortfolioFragment : Fragment() {

    @Inject
    lateinit var portfolioAdapter: PortfolioAdapter
    @Inject
    lateinit var hushViewModelFactory: HushViewModelFactory

    private lateinit var portfolioViewModel: PortfolioViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_portfolio, container, false)
        setHasOptionsMenu(true)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val menuItem = menu.findItem(R.id.search)
        val searchView = menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                portfolioAdapter.filter.filter(p0)
                return false
            }

        })

    }

    private fun initUI() {
        initViewModel()
        initRecyclerView()
    }

    private fun initViewModel() {
        portfolioViewModel =
            ViewModelProvider(this, hushViewModelFactory).get(PortfolioViewModel::class.java)
        portfolioViewModel.portfolioData.observe(viewLifecycleOwner, Observer {
            Log.d("-----P","------")
            progress_bar.visibility = View.INVISIBLE
            it?.let {
                portfolioAdapter.submitList(it as ArrayList<Portfolio>)
            }
        })
    }

    private fun initRecyclerView() {
        with(recycler) {
            layoutManager = LinearLayoutManager(activity)
            adapter = portfolioAdapter
        }

    }


}

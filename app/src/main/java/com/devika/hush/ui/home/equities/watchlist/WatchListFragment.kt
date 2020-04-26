package com.devika.hush.ui.home.equities.watchlist


import android.annotation.SuppressLint
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
import com.devika.hush.data.model.DetailWatchList
import kotlinx.android.synthetic.main.fragment_watch_list.*
import com.devika.hush.utils.HushViewModelFactory
import javax.inject.Inject

class WatchListFragment : Fragment() {

    @Inject
    lateinit var hushViewModelFactory: HushViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_watch_list, container, false)

        setHasOptionsMenu(true)
        return root
    }
}

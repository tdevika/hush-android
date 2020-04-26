package com.devika.hush.ui.home.equities.watchlist

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devika.hush.HushApplication
import com.devika.hush.R
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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_watch_list, container, false)

        setHasOptionsMenu(true)
        return root
    }
}

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
import com.devika.hush.databinding.FragmentStocksBinding
import com.devika.hush.ui.base.BaseFragment
import com.devika.hush.utils.DateUtils
import com.devika.hush.utils.HushViewModelFactory
import kotlinx.android.synthetic.main.fragment_stocks.*
import java.util.*
import javax.inject.Inject

class StocksFragment : BaseFragment<FragmentStocksBinding, StocksViewModel>() {


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    override fun getViewModelClass(): Class<StocksViewModel> = StocksViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_stocks

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToModel()
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
    }
}

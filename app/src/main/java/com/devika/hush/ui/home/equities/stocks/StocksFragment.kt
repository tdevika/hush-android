package com.devika.hush.ui.home.equities.stocks

import android.content.Context
import android.os.Bundle
import android.view.View
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.databinding.FragmentStocksBinding
import com.devika.hush.ui.base.BaseFragment

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

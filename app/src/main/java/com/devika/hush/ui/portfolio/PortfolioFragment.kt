package com.devika.hush.ui.portfolio

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.base.BaseFragment
import com.devika.hush.databinding.FragmentPortfolioBinding

class PortfolioFragment : BaseFragment<FragmentPortfolioBinding, PortfolioViewModel>() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    override fun layoutId() = R.layout.fragment_portfolio

    override fun getViewModelClass() = PortfolioViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToModel()
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
    }
}

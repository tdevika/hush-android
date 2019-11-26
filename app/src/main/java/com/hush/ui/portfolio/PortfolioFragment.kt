package com.hush.ui.portfolio

import android.os.Bundle
import android.view.View
import com.hush.R
import com.hush.databinding.FragmentPortfolioBinding
import com.hush.ui.base.BaseFragment

class PortfolioFragment : BaseFragment<FragmentPortfolioBinding, PortfolioFragmentViewModel>() {

    override fun layoutId() = R.layout.fragment_portfolio

    override fun getViewModelClass() = PortfolioFragmentViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}

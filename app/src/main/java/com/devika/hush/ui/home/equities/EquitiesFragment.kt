package com.devika.hush.ui.home.equities

import android.content.Context
import android.os.Bundle
import android.view.View
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.databinding.FragmentEquitiesBinding
import com.devika.hush.ui.base.BaseFragment

class EquitiesFragment : BaseFragment<FragmentEquitiesBinding, EquitiesViewModel>() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    override fun layoutId() = R.layout.fragment_equities

    override fun getViewModelClass() = EquitiesViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToModel()
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
    }
}

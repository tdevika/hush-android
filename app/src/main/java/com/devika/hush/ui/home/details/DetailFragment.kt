package com.devika.hush.ui.home.details

import android.os.Bundle
import android.view.View
import com.devika.hush.R
import com.devika.hush.databinding.FragmentDetailsBinding
import com.devika.hush.ui.base.BaseFragment

class DetailFragment : BaseFragment<FragmentDetailsBinding, DetailsViewModel>() {

    override fun getViewModelClass(): Class<DetailsViewModel> = DetailsViewModel::class.java

    override fun layoutId(): Int = R.layout.fragment_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToModel()
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
    }

}
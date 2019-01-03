package com.xpns.ui.search

import android.os.Bundle
import com.xpns.R
import com.xpns.databinding.ActivitySearchBinding
import com.xpns.ui.base.BaseActivity

class SearchActivity : BaseActivity<ActivitySearchBinding, SearchViewModel>() {

    override fun getViewModelClass() = SearchViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.activity_search
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeToModel()
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
    }

}
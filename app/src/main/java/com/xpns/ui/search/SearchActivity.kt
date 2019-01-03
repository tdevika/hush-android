package com.xpns.ui.search

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.xpns.R
import com.xpns.databinding.ActivitySearchBinding
import com.xpns.ui.base.BaseActivity
import com.xpns.utils.SpacesItemDecoration
import javax.inject.Inject

class SearchActivity : BaseActivity<ActivitySearchBinding, SearchViewModel>() {

    @Inject
    lateinit var searchAdapter: SearchAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun getViewModelClass() = SearchViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.activity_search
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeUI()
        subscribeToModel()
    }

    private fun initializeUI() {
//        with(binding.rvCategory) {
//            layoutManager = linearLayoutManager
//            adapter = searchAdapter
//        }
//        binding.rvCategory.addItemDecoration(SpacesItemDecoration(6))

    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
    }

}
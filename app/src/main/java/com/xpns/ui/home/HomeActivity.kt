package com.xpns.ui.home

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.xpns.R
import com.xpns.databinding.ActivityHomeBinding
import com.xpns.ui.base.BaseActivity
import javax.inject.Inject

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    @Inject
    lateinit var homeListAdapter: HomeListAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun getViewModelClass() = HomeViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.activity_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeUI()
        subscribeToModel()
    }

    private fun initializeUI() {
        with(binding.recyclerView) {
            layoutManager = linearLayoutManager
            adapter = homeListAdapter
        }
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
    }
}
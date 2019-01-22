package com.xpns.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.xpns.R
import com.xpns.data.model.XpnsItems
import com.xpns.databinding.ActivityHomeBinding
import com.xpns.ui.addxpns.DetailFragment
import com.xpns.ui.base.BaseActivity
import com.xpns.utils.DataWrapper
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
        if (savedInstanceState == null)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container, DetailFragment.newInstance())
                    .commitAllowingStateLoss()

    }

    private fun initializeUI() {
        with(binding.recyclerView) {
            layoutManager = linearLayoutManager
            adapter = homeListAdapter
        }
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
        viewModel.repositoriesLiveData.observe(this, subscribersObserver())
        binding.setLifecycleOwner(this)
    }

    private fun subscribersObserver(): Observer<DataWrapper<XpnsItems>> {
        return Observer {
            viewModel.displayLoader(false)
            it?.let {
                if (!it.isError) {
                    homeListAdapter.updateData(it.data?.items!!)
                } else {
                    viewModel.setErrorMessage(it.isError, it.errorMessage)
                }
            }
        }
    }
}
package com.xpns.ui.detail

import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.xpns.R
import com.xpns.data.model.Subscribers
import com.xpns.ui.base.BaseActivity
import com.xpns.utils.Constants
import com.xpns.utils.DataWrapper
import com.xpns.databinding.ActivityDetailBinding

import javax.inject.Inject

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {

    @Inject
    lateinit var detailAdapter: DetailAdapter

    @Inject
    lateinit var linearLayoutManager: androidx.recyclerview.widget.LinearLayoutManager

    @Inject
    lateinit var eventHandler: DetailEventHandler

    override fun getViewModelClass() = DetailViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.activity_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeUI()
        subscribeToModel()
        loadRepoSubscribers()
    }

    private fun initializeUI() {
        setSupportActionBar(binding.toolbar)
        with(binding.recyclerView) {
            layoutManager = linearLayoutManager
            adapter = detailAdapter
        }
        val name = intent.getStringExtra(Constants.EXTRA_REPO_NAME)
        name?.let { binding.name.text = it }

    }

    private fun loadRepoSubscribers() {
        val url = intent.getStringExtra(Constants.EXTRA_SUBSCRIBERS_URL)
        binding.subscriberUrl = url
        viewModel.fetchRepositorySubscribers(url)
    }

    private fun subscribeToModel() {
        binding.detailViewModel = viewModel
        binding.eventHandler = eventHandler
        viewModel.subscribersLiveData.observe(this, subscribersObserver())
        binding.setLifecycleOwner(this)

    }

    private fun subscribersObserver(): Observer<DataWrapper<List<Subscribers>>> {
        return Observer {
            viewModel.displayLoader(false)
            it?.let {
                if (!it.isError) {
                    var subscribersCount = 0
                    it.data?.size?.let { subscribersCount = it }
                    binding.count.text = String.format(" %d", subscribersCount)
                    if (subscribersCount > 0) {
                        detailAdapter.updateData(it.data!!)
                        viewModel.setErrorMessage(false, Constants.EMPTY_MESSAGE)
                    } else {
                        viewModel.setErrorMessage(true, getString(R.string.empty_search_result))
                    }
                } else {
                    viewModel.setErrorMessage(it.isError, it.errorMessage)
                }
            }
        }
    }
}
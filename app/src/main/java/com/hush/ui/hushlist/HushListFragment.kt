package com.hush.ui.hushlist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hush.R
import com.hush.data.model.HushItems
import com.hush.databinding.FragmentHushListBinding
import com.hush.ui.base.BaseFragment
import com.hush.utils.DataWrapper
import com.hush.utils.HomeActivityDelegate
import javax.inject.Inject

class HushListFragment : BaseFragment<FragmentHushListBinding, HushListFragmentViewModel>(), HomeActivityDelegate {

    @Inject
    lateinit var hushListAdapter: HushListAdapter

    override fun layoutId() = R.layout.fragment_hush_list

    override fun getViewModelClass() = HushListFragmentViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        subscribeToModel()
    }

    private fun initializeUI() {
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(activity)
            adapter = hushListAdapter
        }
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
        viewModel.repositoriesLiveData.observe(this, subscribersObserver())
        binding.setLifecycleOwner(this)
    }

    private fun subscribersObserver(): Observer<DataWrapper<HushItems>> {
        return Observer {
            viewModel.displayLoader(false)
            it?.let {
                if (!it.isError) {
                    hushListAdapter.updateData(it.data?.items!!)
                } else {
                    viewModel.setErrorMessage(it.isError, it.errorMessage)
                }
            }
        }
    }

    override fun onFabClicked() {
    }

}

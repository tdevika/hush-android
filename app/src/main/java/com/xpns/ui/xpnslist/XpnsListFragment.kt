package com.xpns.ui.xpnslist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.xpns.R
import com.xpns.data.model.XpnsItems
import com.xpns.databinding.FragmentXpnsListBinding
import com.xpns.ui.base.BaseFragment
import com.xpns.utils.DataWrapper
import javax.inject.Inject

class XpnsListFragment : BaseFragment<FragmentXpnsListBinding, XpnsListFragmentViewModel>() {


    @Inject
    lateinit var xpnsListAdapter: XpnsListAdapter

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun layoutId() = R.layout.fragment_xpns_list

    override fun getViewModelClass() = XpnsListFragmentViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
        subscribeToModel()
    }
    private fun initializeUI() {
        with(binding.recyclerView) {
            layoutManager = linearLayoutManager
            adapter = xpnsListAdapter
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
                    xpnsListAdapter.updateData(it.data?.items!!)
                } else {
                    viewModel.setErrorMessage(it.isError, it.errorMessage)
                }
            }
        }
    }
}

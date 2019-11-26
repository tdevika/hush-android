//package com.hush.ui.watchlist
//
//import android.os.Bundle
//import android.view.View
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.hush.R
//import com.hush.data.model.Portfolio
//import com.hush.databinding.FragmentHushListBinding
//import com.hush.ui.base.BaseFragment
//import com.hush.ui.hushlist.HushListAdapter
//import com.hush.ui.hushlist.HushListFragmentViewModel
//import com.hush.utils.DataWrapper
//import com.hush.utils.HomeActivityDelegate
//import javax.inject.Inject
//
//class WatchlistFragment : BaseFragment<FragmentHushListBinding, HushListFragmentViewModel>(), HomeActivityDelegate {
//
//    @Inject
//    lateinit var hushListAdapter: HushListAdapter
//
//    override fun layoutId() = R.layout.fragment_hush_list
//
//    override fun getViewModelClass() = HushListFragmentViewModel::class.java
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        initializeUI()
//        subscribeToModel()
//    }
//
//    private fun initializeUI() {
//        with(binding.recyclerView) {
//            layoutManager = LinearLayoutManager(context)
//            adapter = hushListAdapter
//        }
//    }
//
//    private fun subscribeToModel() {
//        binding.viewModel = viewModel
//        viewModel.repositoriesLiveData.observe(this, subscribersObserver())
//        binding.setLifecycleOwner(this)
//    }
//
//    private fun subscribersObserver(): Observer<DataWrapper<List<Portfolio>>> {
//        return Observer {
//            viewModel.displayLoader(false)
//            it?.let {
//                if (!it.isError) {
//                    hushListAdapter.updateData(sortList(it.data!!))
//                } else {
//                    viewModel.setErrorMessage(it.isError, it.errorMessage)
//                }
//            }
//        }
//    }
//
//    private fun sortList(data: List<Portfolio>): List<Portfolio> {
//        //return  data.filter { it.index52W()<10 }
//        return  data.filter { it.close_price.toFloat()>0 }
//    }
//
//    override fun onFabClicked() {
//    }
//
//}

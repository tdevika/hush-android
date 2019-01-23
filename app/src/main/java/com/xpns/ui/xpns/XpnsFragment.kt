package com.xpns.ui.xpns

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.xpns.R
import com.xpns.databinding.FragmentXpnsBinding
import com.xpns.ui.base.BaseFragment
import com.xpns.utils.DataWrapper

class XpnsFragment : BaseFragment<FragmentXpnsBinding, XpnsFragmentViewModel>() {

    override fun getViewModelClass() = XpnsFragmentViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.fragment_xpns
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToModel()
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
        viewModel.repositoriesLiveData.observe(this, repositoriesObserver())
        binding.setLifecycleOwner(this)
    }

    private fun repositoriesObserver(): Observer<DataWrapper<String>> {
        return Observer {
            viewModel.displayLoader(false)
            it?.let {
                if (!it.isError) {
                    Toast.makeText(context, "Expense added", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Error" + it.errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
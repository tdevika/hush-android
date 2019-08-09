package com.hush.ui.hush

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.hush.R
import com.hush.databinding.FragmentHushBinding
import com.hush.ui.base.BaseFragment
import com.hush.utils.DataWrapper
import com.hush.utils.HomeActivityDelegate

class HushFragment : BaseFragment<FragmentHushBinding, HushFragmentViewModel>(), HomeActivityDelegate {

    override fun getViewModelClass() = HushFragmentViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.fragment_hush
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToModel()
    }

    private fun subscribeToModel() {
    //    binding.viewModel = viewModel
      //  viewModel.repositoriesLiveData.observe(this, repositoriesObserver())
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

    override fun onFabClicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
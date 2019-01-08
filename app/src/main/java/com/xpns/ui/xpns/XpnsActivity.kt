package com.xpns.ui.xpns

import android.os.Bundle
import com.xpns.R
import com.xpns.databinding.ActivityXpnsBinding
import com.xpns.ui.base.BaseActivity


class XpnsActivity : BaseActivity<ActivityXpnsBinding, XpnsViewModel>() {

    override fun getViewModelClass() = XpnsViewModel::class.java

    override fun layoutId(): Int {
        return R.layout.activity_xpns
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
package com.xpns.ui.home

import com.xpns.R
import com.xpns.databinding.ActivityHomeBinding
import com.xpns.ui.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    override fun getViewModelClass() = HomeViewModel::class.java

    override fun layoutId() = R.layout.activity_home

}
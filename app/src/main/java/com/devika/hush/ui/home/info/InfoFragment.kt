package com.devika.hush.ui.home.info

import android.content.Context
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.databinding.FragmentExploreBinding
import com.devika.hush.ui.base.BaseFragment

class InfoFragment : BaseFragment<FragmentExploreBinding, InfoViewModel>() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    override fun layoutId() = R.layout.fragment_info

    override fun getViewModelClass() = InfoViewModel::class.java
}

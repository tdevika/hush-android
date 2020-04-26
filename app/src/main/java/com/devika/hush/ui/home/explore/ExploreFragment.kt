package com.devika.hush.ui.home.explore

import android.content.Context
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.databinding.FragmentExploreBinding
import com.devika.hush.ui.base.BaseFragment

class ExploreFragment : BaseFragment<FragmentExploreBinding, ExploreViewModel>() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as HushApplication).appComponent.inject(this)
    }

    override fun layoutId() = R.layout.fragment_explore

    override fun getViewModelClass() = ExploreViewModel::class.java
}

package com.xpns.ui.addxpns

import android.os.Bundle
import android.util.Log
import com.xpns.R
import com.xpns.databinding.FragmentDetailBinding
import com.xpns.ui.base.BaseFragment

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailFragmentViewModel>() {
    override fun layoutId(): Int {
        return R.layout.fragment_detail
    }

    override fun getViewModelClass()=DetailFragmentViewModel::class.java


    fun onDetailFragmentLoaded() {
        Log.v("TEST", "OnDetailFragmentLoaded.")
    }

    companion object {

        fun newInstance(): DetailFragment {
            val args = Bundle()
            val fragment = DetailFragment()
            fragment.arguments = args
            return fragment
        }
    }
}

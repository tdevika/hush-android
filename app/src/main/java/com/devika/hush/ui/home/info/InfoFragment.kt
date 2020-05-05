package com.devika.hush.ui.home.info

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devika.hush.HushApplication
import com.devika.hush.databinding.FragmentInfoBinding
import com.devika.hush.injection.component.injector
import com.devika.hush.utils.HushViewModelFactory
import com.devika.hush.utils.viewModelProvider
import javax.inject.Inject

class InfoFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: HushViewModelFactory

    private lateinit var binding: FragmentInfoBinding
    private lateinit var viewModel: InfoViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
       injector.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = viewModelProvider(viewModelFactory)
    }


}

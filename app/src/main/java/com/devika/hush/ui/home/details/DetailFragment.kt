package com.devika.hush.ui.home.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devika.hush.databinding.FragmentDetailsBinding
import com.devika.hush.injection.component.injector
import com.devika.hush.utils.HushViewModelFactory
import com.devika.hush.utils.viewModelProvider
import javax.inject.Inject

class DetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: HushViewModelFactory

    private lateinit var viewModel: DetailsViewModel

    private lateinit var binding: FragmentDetailsBinding

    private val symbol: String?
        get() = arguments?.let { DetailFragmentArgs.fromBundle(it).symbol }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = viewModelProvider(viewModelFactory)
        subscribeToModel()
    }

    private fun subscribeToModel() {
        binding.viewModel = viewModel
        symbol?.let { viewModel.getStockDetails(it) }
    }
}

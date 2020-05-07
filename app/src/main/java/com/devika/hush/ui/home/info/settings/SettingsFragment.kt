//package com.devika.hush.ui.home.info.settings
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModelProvider
//import com.google.samples.apps.iosched.ui.info.SettingsViewModel
//import javax.inject.Inject
//
//class SettingsFragment : Fragment() {
//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val settingsViewModel: SettingsViewModel = viewModelProvider(viewModelFactory)
//        val binding = FragmentSettingsBinding.inflate(inflater, container, false).apply {
//            viewModel = settingsViewModel
//            isInstantApp = InstantApps.isInstantApp(requireContext())
//            lifecycleOwner = viewLifecycleOwner
//        }
//        settingsViewModel.showSignIn.observe(this, EventObserver {
//            notificationDialogDispatcher.startDialog(requireActivity())
//        })
//        settingsViewModel.navigateToThemeSelector.observe(this, EventObserver {
//            ThemeSettingDialogFragment.newInstance().show(requireFragmentManager(), null)
//        })
//        return binding.root
//    }
//}

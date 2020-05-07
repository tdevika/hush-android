package com.devika.hush.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.devika.hush.HushApplication
import com.devika.hush.R
import com.devika.hush.data.repository.PreferenceRepository
import com.devika.hush.databinding.ActivityHomeBinding
import com.devika.hush.utils.HushViewModelFactory
import com.devika.hush.utils.setupWithNavController
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: HomeViewModel
    private var currentNavController: LiveData<NavController>? = null

    @Inject
    lateinit var viewModelFactory: HushViewModelFactory

    @Inject
    lateinit var preferenceRepository: PreferenceRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as HushApplication).appComponent.inject(this)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_home
        )
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
        preferenceRepository.nightModeLive.observe(
            this,
            Observer { nightMode ->
                nightMode?.let { delegate.localNightMode = it }
            }
        )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(
            R.navigation.nav_equities,
            R.navigation.nav_explore,
            R.navigation.nav_info
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = binding.navigation.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment,
            intent = intent
        )

        controller.value?.addOnDestinationChangedListener { _, destination, _ ->
            binding.navigation.visibility = when (destination.id) {
                R.id.equitiesFragment -> View.VISIBLE
                else -> View.VISIBLE
            }
        }
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}

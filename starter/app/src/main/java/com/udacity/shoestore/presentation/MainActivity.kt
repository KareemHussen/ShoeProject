package com.udacity.shoestore.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[ShoeViewModel::class.java]
    }

    private val appBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(
                R.id.shoeListFragment,
                R.id.loginFragment
            )
        )
    }


    private  val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
    }

    private val navController by lazy {
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController)
        binding.toolbar.setupWithNavController(navController,appBarConfiguration)

        viewModel.addShoes()


    }
}

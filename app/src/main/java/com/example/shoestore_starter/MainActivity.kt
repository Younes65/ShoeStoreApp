package com.example.shoestore_starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.shoestore_starter.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        Timber.plant(Timber.DebugTree())

        val controller =this.findNavController(R.id.fragmentContainer)
        NavigationUI.setupActionBarWithNavController(this, controller)
        AppBarConfiguration(controller.graph)

    }

    override fun onSupportNavigateUp(): Boolean {
        val controller =this.findNavController(R.id.fragmentContainer)
        return controller.navigateUp()
    }


}
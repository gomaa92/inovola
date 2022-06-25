package com.gomaa.inovola.features.splash

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.gomaa.inovola.R
import com.gomaa.inovola.base.presentation.view.fragments.BaseFragment
import com.gomaa.inovola.databinding.FragmentSplashBindingImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBindingImpl>(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadSplashScreen()

    }

    private fun loadSplashScreen() {
        lifecycleScope.launch(Dispatchers.Main) {
            delay(2000)
            view?.findNavController()?.navigate(R.id.writersFragment)
        }
    }


    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)?.supportActionBar?.show()
    }
}
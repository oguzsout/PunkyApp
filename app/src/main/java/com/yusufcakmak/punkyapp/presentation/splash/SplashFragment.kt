package com.yusufcakmak.punkyapp.presentation.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yusufcakmak.punkyapp.R
import com.yusufcakmak.punkyapp.databinding.FragmentSplashBinding
import com.yusufcakmak.punkyapp.presentation.base.BaseFragment
import kotlinx.coroutines.delay

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    override val layoutRes: Int = R.layout.fragment_splash

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            delay(2000)
            findNavController().navigate(R.id.action_navigation_splash_to_navigation_home)
        }
    }

}
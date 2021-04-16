package com.yusufcakmak.punkyapp.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.squareup.picasso.Picasso
import com.yusufcakmak.punkyapp.R
import com.yusufcakmak.punkyapp.databinding.FragmentHomeBinding
import com.yusufcakmak.punkyapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModels()

    override val layoutRes: Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.fetchBeers()

        homeViewModel.contents_.observe(viewLifecycleOwner, {
            Log.v("TEST4", "list " + it[0].name)
            Picasso.get().load(it[0].imageUrl).into(binding.ivBeerImage)
            binding.tvBeerName.text = it[0].name
            binding.tvTagLine.text = it[0].tagline
        })

        binding.tvRandomBeer.setOnClickListener {
            homeViewModel.fetchBeers()
        }

    }
}
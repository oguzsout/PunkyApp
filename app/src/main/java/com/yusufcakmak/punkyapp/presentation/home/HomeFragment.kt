package com.yusufcakmak.punkyapp.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.squareup.picasso.Picasso
import com.yusufcakmak.punkyapp.R
import com.yusufcakmak.punkyapp.databinding.FragmentHomeBinding
import com.yusufcakmak.punkyapp.domain.model.Cocktail
import com.yusufcakmak.punkyapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModels()

    override val layoutRes: Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {
        homeViewModel.contents_.observe(viewLifecycleOwner, {
            Picasso.get().load(it.drinks[0].strDrinkThumb).into(binding.ivBeerImage)
            initUI(it.drinks)
        })
    }

    private fun initUI(list: List<Cocktail>) {
        binding.viewState = HomeViewState(list[0])
        binding.executePendingBindings()
    }
}
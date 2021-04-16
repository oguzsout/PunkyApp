package com.yusufcakmak.punkyapp.ui.detail

import android.os.Bundle
import android.view.View
import com.yusufcakmak.punkyapp.R
import com.yusufcakmak.punkyapp.databinding.FragmentDetailBinding
import com.yusufcakmak.punkyapp.ui.base.BaseFragment

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override val layoutRes: Int = R.layout.fragment_detail

    private lateinit var detailViewModel: DetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
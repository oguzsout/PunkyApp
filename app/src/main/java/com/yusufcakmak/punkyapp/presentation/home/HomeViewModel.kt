package com.yusufcakmak.punkyapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufcakmak.punkyapp.common.doOnStatusChanged
import com.yusufcakmak.punkyapp.common.doOnSuccess
import com.yusufcakmak.punkyapp.domain.model.Beer
import com.yusufcakmak.punkyapp.domain.usecase.FetchBeerUseCase
import com.yusufcakmak.punkyapp.presentation.base.StatusViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchBeerUseCase: FetchBeerUseCase
) : ViewModel() {

    private val contents = MutableLiveData<List<Beer>>()
    val contents_: LiveData<List<Beer>> = contents

    private val status = MutableLiveData<StatusViewState>()
    val status_: LiveData<StatusViewState> = status


    fun fetchBeers() {
        fetchBeerUseCase
            .fetchBeers()
            .doOnSuccess { data ->
                contents.value = data
            }
            .doOnStatusChanged {
                status.value = StatusViewState(status = it)
            }
            .launchIn(viewModelScope)
    }

}
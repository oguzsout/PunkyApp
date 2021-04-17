package com.yusufcakmak.punkyapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufcakmak.punkyapp.common.doOnStatusChanged
import com.yusufcakmak.punkyapp.common.doOnSuccess
import com.yusufcakmak.punkyapp.domain.model.Cocktail
import com.yusufcakmak.punkyapp.domain.model.CocktailWrapper
import com.yusufcakmak.punkyapp.domain.usecase.FetchCocktailUseCase
import com.yusufcakmak.punkyapp.presentation.base.StatusViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchBeerUseCase: FetchCocktailUseCase
) : ViewModel() {

    private val contents = MutableLiveData<CocktailWrapper>()
    val contents_: LiveData<CocktailWrapper> = contents

    private val status = MutableLiveData<StatusViewState>()
    val status_: LiveData<StatusViewState> = status

    init {
        fetchCocktails()
    }

    fun fetchCocktails() {
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
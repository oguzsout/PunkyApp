package com.yusufcakmak.punkyapp.data.remote

import com.yusufcakmak.punkyapp.data.model.CocktailWrapperResponse

interface RemoteCocktailDataSource {

    suspend fun fetchCocktails() : CocktailWrapperResponse
}
package com.yusufcakmak.punkyapp.repository

import com.yusufcakmak.punkyapp.data.remote.RemoteCocktailDataSource
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    private val remoteBeerDataSource: RemoteCocktailDataSource
) {
    suspend fun fetchCocktail() = remoteBeerDataSource.fetchCocktails()
}
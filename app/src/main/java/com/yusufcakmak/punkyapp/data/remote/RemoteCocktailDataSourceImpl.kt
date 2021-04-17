package com.yusufcakmak.punkyapp.data.remote

import com.yusufcakmak.punkyapp.data.IoDispatcher
import com.yusufcakmak.punkyapp.data.api.CoctailService
import com.yusufcakmak.punkyapp.data.model.CocktailResponse
import com.yusufcakmak.punkyapp.data.model.CocktailWrapperResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteCocktailDataSourceImpl @Inject constructor(
    private val service: CoctailService,

    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : RemoteCocktailDataSource {

    override suspend fun fetchCocktails(): CocktailWrapperResponse = withContext(dispatcher) {
        service.fetchRandomCocktails()
    }
}
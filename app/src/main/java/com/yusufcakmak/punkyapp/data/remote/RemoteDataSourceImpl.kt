package com.yusufcakmak.punkyapp.data.remote

import com.yusufcakmak.punkyapp.data.IoDispatcher
import com.yusufcakmak.punkyapp.data.api.BeerService
import com.yusufcakmak.punkyapp.data.model.BeerResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: BeerService,

    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : RemoteBeerDataSource {

    override suspend fun fetchBeers(): List<BeerResponse> = withContext(dispatcher) {
        service.fetchRandomBeer()
            .map { it }
    }
}
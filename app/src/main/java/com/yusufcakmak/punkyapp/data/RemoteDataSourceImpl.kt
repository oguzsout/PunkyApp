package com.yusufcakmak.punkyapp.data

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
package com.yusufcakmak.punkyapp.domain

import com.yusufcakmak.punkyapp.common.Mapper
import com.yusufcakmak.punkyapp.common.Resource
import com.yusufcakmak.punkyapp.data.BeerResponse
import com.yusufcakmak.punkyapp.data.IoDispatcher
import com.yusufcakmak.punkyapp.repository.BeerRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class FetchBeerUseCase @Inject constructor(
    private val repository: BeerRepository,
    private val beerDataMapper: Mapper<BeerResponse, Beer>,
    @IoDispatcher val dispatcher: CoroutineDispatcher
) {
    fun fetchBeers() = flow {
        emit(Resource.Loading)
        val beers = repository.fetchBeers()
        emit(Resource.Success(beers.map {
            beerDataMapper.map(it)
        }))
    }.catch {
        emit(Resource.Error(it))
    }.flowOn(dispatcher)
}
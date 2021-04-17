package com.yusufcakmak.punkyapp.domain.usecase

import com.yusufcakmak.punkyapp.common.Resource
import com.yusufcakmak.punkyapp.data.IoDispatcher
import com.yusufcakmak.punkyapp.domain.mapper.CocktailWrapperDataMapper
import com.yusufcakmak.punkyapp.repository.CocktailRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class FetchCocktailUseCase @Inject constructor(
    private val repository: CocktailRepository,
    private val cocktailWrapperDataMapper: CocktailWrapperDataMapper,
    @IoDispatcher val dispatcher: CoroutineDispatcher
) {
    fun fetchBeers() = flow {
        emit(Resource.Loading)
        val cocktail = repository.fetchCocktail()
        emit(Resource.Success(cocktailWrapperDataMapper.map(cocktail)))
    }.catch {
        emit(Resource.Error(it))
    }.flowOn(dispatcher)
}
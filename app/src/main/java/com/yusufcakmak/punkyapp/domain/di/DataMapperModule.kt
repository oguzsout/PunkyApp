package com.yusufcakmak.punkyapp.domain.di

import com.yusufcakmak.punkyapp.common.Mapper
import com.yusufcakmak.punkyapp.data.model.CocktailResponse
import com.yusufcakmak.punkyapp.data.model.CocktailWrapperResponse
import com.yusufcakmak.punkyapp.domain.model.Cocktail
import com.yusufcakmak.punkyapp.domain.mapper.CocktailDataMapper
import com.yusufcakmak.punkyapp.domain.mapper.CocktailWrapperDataMapper
import com.yusufcakmak.punkyapp.domain.model.CocktailWrapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataMapperModule {

    @Provides
    @Singleton
    fun provideCocktailMapper(): Mapper<List<CocktailResponse>, List<Cocktail>> {
        return CocktailDataMapper()
    }

    @Provides
    @Singleton
    fun provideCocktailWrapperMapper(
        cocktailDataMapper: CocktailDataMapper
    ): Mapper<CocktailWrapperResponse, CocktailWrapper> {
        return CocktailWrapperDataMapper(cocktailDataMapper)
    }
}

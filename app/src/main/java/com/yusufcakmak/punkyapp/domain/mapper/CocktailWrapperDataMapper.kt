package com.yusufcakmak.punkyapp.domain.mapper

import com.yusufcakmak.punkyapp.common.Mapper
import com.yusufcakmak.punkyapp.data.model.CocktailResponse
import com.yusufcakmak.punkyapp.data.model.CocktailWrapperResponse
import com.yusufcakmak.punkyapp.domain.model.Cocktail
import com.yusufcakmak.punkyapp.domain.model.CocktailWrapper
import javax.inject.Inject

class CocktailWrapperDataMapper @Inject constructor(
    private val cocktailDataMapper: CocktailDataMapper
) : Mapper<CocktailWrapperResponse, CocktailWrapper> {

    override fun map(coctail: CocktailWrapperResponse): CocktailWrapper {
        return CocktailWrapper(
            drinks = cocktailDataMapper.map(coctail.drinks)
        )
    }
}
package com.yusufcakmak.punkyapp.domain.mapper

import com.yusufcakmak.punkyapp.common.Mapper
import com.yusufcakmak.punkyapp.data.model.CocktailResponse
import com.yusufcakmak.punkyapp.domain.model.Cocktail
import javax.inject.Inject

class CocktailDataMapper @Inject constructor() : Mapper<List<CocktailResponse>, List<Cocktail>> {

    override fun map(coctails: List<CocktailResponse>): List<Cocktail> {
        return coctails.map {
            convertResponseToModel(it)
        }
    }

    private fun convertResponseToModel(response: CocktailResponse): Cocktail {
        val ingredientList = mutableListOf<String?>()
        ingredientList.add(response.strIngredient1)
        ingredientList.add(response.strIngredient2)
        response.strIngredient3?.let {
            ingredientList.add(it)
        }
        response.strIngredient4?.let {
            ingredientList.add(it)
        }

        return Cocktail(
            idDrink = response.idDrink,
            strDrink = response.strDrink,
            strCategory = response.strCategory,
            strIngredients = ingredientList.toList(),
            strDrinkThumb = response.strDrinkThumb,
            strInstructions = response.strInstructions
        )
    }
}
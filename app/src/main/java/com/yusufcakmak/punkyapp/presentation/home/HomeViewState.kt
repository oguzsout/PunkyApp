package com.yusufcakmak.punkyapp.presentation.home

import com.yusufcakmak.punkyapp.domain.model.Cocktail

class HomeViewState(
   cocktail: Cocktail
){
    val cocktailName = cocktail.strDrink
    val category = cocktail.strCategory
    val desc = cocktail.strInstructions
    val ingredient = cocktail.strIngredients
}
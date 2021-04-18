package com.yusufcakmak.punkyapp.domain.model

data class Cocktail(
    val idDrink: Int,
    val strDrink: String?,
    val strCategory: String?,
    val strDrinkThumb: String?,
    val strInstructions: String?,
    val strIngredients : List<String?>
)
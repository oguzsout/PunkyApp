package com.yusufcakmak.punkyapp.data.model

import com.google.gson.annotations.SerializedName

data class CocktailResponse(
    @SerializedName("idDrink")
    val idDrink: Int,
    @SerializedName("strDrink")
    val strDrink: String?,
    @SerializedName("strCategory")
    val strCategory: String?,
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String?,
    @SerializedName("strInstructions")
    val strInstructions: String?,
    @SerializedName("strIngredient1")
    val strIngredient1: String?,
    @SerializedName("strIngredient2")
    val strIngredient2: String?,
    @SerializedName("strIngredient3")
    val strIngredient3: String?,
    @SerializedName("strIngredient4")
    val strIngredient4: String?
)
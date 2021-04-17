package com.yusufcakmak.punkyapp.data.model

import com.google.gson.annotations.SerializedName

data class CocktailWrapperResponse(
    @SerializedName("drinks")
    val drinks: List<CocktailResponse>
)
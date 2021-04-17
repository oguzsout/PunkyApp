package com.yusufcakmak.punkyapp.data.api

import com.yusufcakmak.punkyapp.data.model.CocktailResponse
import com.yusufcakmak.punkyapp.data.model.CocktailWrapperResponse
import retrofit2.http.GET

interface CoctailService {

    @GET("/api/json/v1/1/random.php")
    suspend fun fetchRandomCocktails() : CocktailWrapperResponse
}
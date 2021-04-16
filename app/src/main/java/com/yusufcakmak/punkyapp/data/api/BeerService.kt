package com.yusufcakmak.punkyapp.data.api

import com.yusufcakmak.punkyapp.data.model.BeerResponse
import retrofit2.http.GET

interface BeerService {

    @GET("/v2/beers/random")
    suspend fun fetchRandomBeer() : List<BeerResponse>
}
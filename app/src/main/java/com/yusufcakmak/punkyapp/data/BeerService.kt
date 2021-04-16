package com.yusufcakmak.punkyapp.data

import retrofit2.http.GET

interface BeerService {

    @GET("/v2/beers/random")
    suspend fun fetchRandomBeer() : List<BeerResponse>
}
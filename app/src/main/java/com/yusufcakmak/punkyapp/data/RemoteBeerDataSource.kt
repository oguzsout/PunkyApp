package com.yusufcakmak.punkyapp.data

interface RemoteBeerDataSource {

    suspend fun fetchBeers() : List<BeerResponse>
}
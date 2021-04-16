package com.yusufcakmak.punkyapp.data.remote

import com.yusufcakmak.punkyapp.data.model.BeerResponse

interface RemoteBeerDataSource {

    suspend fun fetchBeers() : List<BeerResponse>
}
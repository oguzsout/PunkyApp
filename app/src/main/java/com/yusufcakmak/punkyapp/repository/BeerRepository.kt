package com.yusufcakmak.punkyapp.repository

import com.yusufcakmak.punkyapp.data.remote.RemoteBeerDataSource
import javax.inject.Inject

class BeerRepository @Inject constructor(
    private val remoteBeerDataSource: RemoteBeerDataSource
) {
    suspend fun fetchBeers() = remoteBeerDataSource.fetchBeers()
}
package com.yusufcakmak.punkyapp.domain

import com.yusufcakmak.punkyapp.common.Mapper
import com.yusufcakmak.punkyapp.data.BeerResponse
import javax.inject.Inject

class BeerDataMapper @Inject constructor() : Mapper<BeerResponse, Beer> {

    override fun map(resp: BeerResponse): Beer {
        return Beer(
            id = resp.id,
            name = resp.name
        )
    }
}
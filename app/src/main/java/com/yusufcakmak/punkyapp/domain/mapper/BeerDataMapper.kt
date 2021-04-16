package com.yusufcakmak.punkyapp.domain.mapper

import com.yusufcakmak.punkyapp.common.Mapper
import com.yusufcakmak.punkyapp.data.model.BeerResponse
import com.yusufcakmak.punkyapp.domain.model.Beer
import javax.inject.Inject

class BeerDataMapper @Inject constructor() : Mapper<BeerResponse, Beer> {

    override fun map(resp: BeerResponse): Beer {
        return Beer(
            id = resp.id,
            name = resp.name
        )
    }
}
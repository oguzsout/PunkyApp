package com.yusufcakmak.punkyapp.common

interface Mapper<In, Out> {
    fun map(input: In): Out
}

package com.yusufcakmak.punkyapp.data.model

import com.google.gson.annotations.SerializedName

data class BeerResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("tagline")
    val tagline: String
)
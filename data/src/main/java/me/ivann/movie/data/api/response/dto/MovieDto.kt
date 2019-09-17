package me.ivann.movie.data.api.response.dto

import com.squareup.moshi.Json

data class MovieDto(
    @Json(name = "title") val title: String,
    @Json(name = "overview") val overview: String
)
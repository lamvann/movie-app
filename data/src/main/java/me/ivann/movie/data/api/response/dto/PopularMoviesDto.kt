package me.ivann.movie.data.api.response.dto

import com.example.domain.entity.Movie
import com.squareup.moshi.Json

data class PopularMoviesDto(
    @Json(name = "results") val results: List<Movie>
)
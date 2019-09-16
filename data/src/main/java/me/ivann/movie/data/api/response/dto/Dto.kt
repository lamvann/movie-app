package me.ivann.movie.data.api.response.dto

import com.squareup.moshi.Json

sealed class Dto {
    data class PopularMovies(
        @Json(name = "results") val results: List<Movie>
    ) : Dto()
    data class Movie(
        @Json(name = "title") val title: String,
        @Json(name = "overview") val overview: String
    ) : Dto()
}
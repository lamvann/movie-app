package me.ivann.movie.domain

import com.squareup.moshi.Json

sealed class Entity {
    data class PopularMovies(
        val results: List<MovieDetails>
    ) : Entity()

    data class MovieDetails(
        val title: String,
        val overview: String,
        @Json(name = "vote_average") val voteAverage: String,
        @Json(name = "release_date") val releaseDate: String
    ) : Entity()
}

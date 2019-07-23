package me.ivann.movie.domain

import com.google.gson.annotations.SerializedName

sealed class Entity {
    data class PopularMovies(
        val results: List<MovieDetails>
    ) : Entity()

    data class MovieDetails(
        val title: String,
        val overview: String,
        @SerializedName("vote_average") val voteAverage: String,
        @SerializedName("release_date") val releaseDate: String
    ) : Entity()
}
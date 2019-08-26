package me.ivann.domain

sealed class Entity {
    data class PopularMovies(
        val results: List<MovieDetails>
    ) : Entity()

    data class MovieDetails(
        val title: String,
        val overview: String,
        val voteAverage: String,
        val releaseDate: String
    ) : Entity()
}

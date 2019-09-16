package com.example.domain

sealed class Entity {
    data class PopularMovies(
        val results: List<Movie>
    ) : Entity()

    data class Movie(
        val title: String,
        val overview: String
    ) : Entity()
}

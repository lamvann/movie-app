package com.example.domain

sealed class Entity {
    data class Movies(
        val movies: List<Movie>
    ) : Entity()

    data class Movie(
        val title: String,
        val overview: String
    ) : Entity()
}

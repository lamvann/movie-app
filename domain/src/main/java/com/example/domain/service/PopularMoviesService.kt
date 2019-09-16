package com.example.domain.service

import com.example.domain.service.movies.BaseService

interface PopularMoviesService : BaseService {
    suspend fun getPopularMovies(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int
    ): List<Entity.Movie>
}
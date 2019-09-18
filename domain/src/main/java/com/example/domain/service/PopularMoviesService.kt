package com.example.domain.service

import com.example.domain.entity.Movie
import com.example.domain.service.movies.BaseService

interface PopularMoviesService : BaseService {
    suspend fun getPopularMovies(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int,
        genre: String = "",
        year: String = ""
    ): Result<List<Movie>>
}
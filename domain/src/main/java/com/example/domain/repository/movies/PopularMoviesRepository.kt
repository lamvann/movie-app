package com.example.domain.repository.movies

import com.example.domain.repository.BaseRepository
import io.reactivex.Observable

interface PopularMoviesRepository : BaseRepository {
    suspend fun get(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int
    ): List<Entity.Movie>
}
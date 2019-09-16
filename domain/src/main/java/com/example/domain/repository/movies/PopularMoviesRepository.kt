package com.example.domain.repository.movies

import com.example.domain.Entity
import com.example.domain.repository.BaseRepository
import io.reactivex.Observable

interface PopularMoviesRepository : BaseRepository {
    fun get(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int
    ): Observable<List<Entity.Movie>>
}
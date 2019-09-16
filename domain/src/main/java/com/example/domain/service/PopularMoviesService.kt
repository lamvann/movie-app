package com.example.domain.service

import com.example.domain.Entity
import com.example.domain.service.movies.BaseService
import io.reactivex.Observable

interface PopularMoviesService : BaseService {
    fun getPopularMovies(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int
    ): Observable<List<Entity.Movie>>
}
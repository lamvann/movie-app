package me.ivann.domain.service

import io.reactivex.Observable
import me.ivann.domain.Entity

interface PopularMoviesService {
    fun getPopularMovies(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int
    ): Observable<Entity.PopularMovies>
}
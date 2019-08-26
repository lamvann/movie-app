package me.ivann.domain.repository

import io.reactivex.Observable
import me.ivann.domain.Entity

interface PopularMoviesRepository {
    fun get(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int
    ): Observable<Entity.PopularMovies>
}
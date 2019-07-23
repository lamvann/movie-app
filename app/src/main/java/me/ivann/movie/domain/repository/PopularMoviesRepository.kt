package me.ivann.movie.domain.repository

import io.reactivex.Observable
import me.ivann.movie.domain.Entity

interface PopularMoviesRepository {
    fun get(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int
    ): Observable<Entity.PopularMovies>
}
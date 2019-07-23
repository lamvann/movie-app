package me.ivann.movie.domain.service

import io.reactivex.Observable
import me.ivann.movie.domain.Entity.PopularMovies

interface PopularMoviesService {
    fun getPopularMovies(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int
    ): Observable<PopularMovies>
}
package me.ivann.movie.data.respository

import io.reactivex.Observable
import me.ivann.movie.domain.Entity
import me.ivann.movie.domain.repository.PopularMoviesRepository
import me.ivann.movie.domain.service.PopularMoviesService
import javax.inject.Inject

/*
 *  Depending on the business rules, we can also persist data from the service
 *  on the device using a database system like Room!
 *
 *  Note: This repository class depends on the service
 *  interface and NOT on the actual class that implements it.
 *
 *  Note2: Injecting all dem dependencies babyyy!
 */

class PopularMoviesRepositoryImpl @Inject constructor(
    private val movieService: PopularMoviesService
) : PopularMoviesRepository {

    override fun get(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int
    ): Observable<Entity.PopularMovies> =
        movieService.getPopularMovies(language, sortBy, includeAdult, page)
}

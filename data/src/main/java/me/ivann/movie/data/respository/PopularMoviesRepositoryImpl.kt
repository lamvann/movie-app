package me.ivann.movie.data.respository

import io.reactivex.Observable
import me.ivann.domain.Entity
import me.ivann.domain.repository.PopularMoviesRepository
import me.ivann.domain.service.PopularMoviesService
import javax.inject.Inject

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

package me.ivann.movie.data.service

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import me.ivann.domain.Entity
import me.ivann.domain.service.PopularMoviesService
import me.ivann.movie.data.api.MovieApi
import javax.inject.Inject

class PopularMoviesServiceImpl @Inject constructor(
    private val movieApi: MovieApi
) : PopularMoviesService {

    override fun getPopularMovies(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int
    ): Observable<Entity.PopularMovies> {
        return movieApi
            .getPopularMovies(KEY_API, language, sortBy, includeAdult, page)
            .subscribeOn(Schedulers.io())
    }
    companion object {
        const val KEY_API = "4a6702592a8127e0bb3c1b65f2654d88"
    }
}

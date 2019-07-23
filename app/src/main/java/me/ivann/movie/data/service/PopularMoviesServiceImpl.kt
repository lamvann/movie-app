package me.ivann.movie.data.service

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import me.ivann.movie.data.api.MovieApi
import me.ivann.movie.domain.Entity
import me.ivann.movie.domain.service.PopularMoviesService
import me.ivann.movie.util.Constants.KEY_API
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
}

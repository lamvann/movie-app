package me.ivann.movie.data.respository

import com.example.domain.Entity
import com.example.domain.repository.movies.PopularMoviesRepository
import com.example.domain.service.PopularMoviesService
import io.reactivex.Observable
import javax.inject.Inject

class PopularMoviesRepositoryImpl @Inject constructor(
    private val movieService: PopularMoviesService
) : PopularMoviesRepository {

    override fun get(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int
    ): Observable<List<Entity.Movie>> =
        movieService.getPopularMovies(language, sortBy, includeAdult, page)
}

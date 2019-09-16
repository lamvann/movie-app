package me.ivann.movie.data.service

import com.example.domain.Entity
import com.example.domain.service.PopularMoviesService
import me.ivann.movie.data.api.MovieApi
import me.ivann.movie.data.api.mapper.map
import javax.inject.Inject

class PopularMoviesServiceImpl @Inject constructor(
    private val movieApi: MovieApi
) : PopularMoviesService {

    override suspend fun getPopularMovies(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int
    ): List<Entity.Movie> {
        return movieApi
            .getPopularMovies(KEY_API, language, sortBy, includeAdult, page)
            .results.map { it.map() }
    }

    companion object {
        const val KEY_API = "4a6702592a8127e0bb3c1b65f2654d88"
    }
}

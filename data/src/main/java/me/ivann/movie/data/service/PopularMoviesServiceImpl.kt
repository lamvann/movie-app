package me.ivann.movie.data.service

import com.example.domain.entity.Movie
import com.example.domain.service.PopularMoviesService
import me.ivann.movie.data.api.MovieApi
import me.ivann.movie.data.api.RestErrorHandler
import me.ivann.movie.data.api.response.dto.PopularMoviesDto

class PopularMoviesServiceImpl(
    private val movieApi: MovieApi
) : PopularMoviesService, RestErrorHandler {

    override suspend fun getPopularMovies(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int,
        genre: String,
        year: String
    ): Result<List<Movie>> {

        return movieApi.getPopularMovies(
            apiKey = KEY_API,
            language = language,
            sortBy = sortBy,
            includeAdult = includeAdult,
            page = page,
            genre = genre,
            year = year
        )
            .handleErrors()
            .map(PopularMoviesDto::results)
    }

    companion object {
        const val KEY_API = "4a6702592a8127e0bb3c1b65f2654d88"
    }
}

class NetworkFailure(message: String) : Throwable(message)
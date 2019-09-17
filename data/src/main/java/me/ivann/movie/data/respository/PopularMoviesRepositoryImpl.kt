package me.ivann.movie.data.respository

import com.example.domain.entity.Movie
import com.example.domain.repository.movies.PopularMoviesRepository
import com.example.domain.service.PopularMoviesService

class PopularMoviesRepositoryImpl(private val movieService: PopularMoviesService) :
    PopularMoviesRepository {

    override val movies: List<Movie> = listOf()

    override suspend fun get(
        language: String,
        sortBy: String,
        includeAdult: String,
        page: Int,
        primaryReleaseYear: String,
        genre: String
    ): Result<List<Movie>> {

        return movieService.getPopularMovies(
            language,
            sortBy,
            includeAdult,
            page,
            genre,
            primaryReleaseYear
        )
    }
}

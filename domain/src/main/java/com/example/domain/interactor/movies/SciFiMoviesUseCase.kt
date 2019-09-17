package com.example.domain.interactor.movies

import com.example.domain.entity.Movie
import com.example.domain.interactor.BaseUseCase
import com.example.domain.repository.movies.PopularMoviesRepository

class SciFiMoviesUseCase(private val repository: PopularMoviesRepository) : BaseUseCase<List<Movie>> {

    override suspend fun run(): Result<List<Movie>> {
        val movies = repository.get(
            primaryReleaseYear = RELEASE_YEAR,
            language = LANGUAGE,
            sortBy = SORT_BY,
            page = PAGE,
            includeAdult = ADULT
        )

        //todo: error handling

        return movies
    }


    companion object {
        // Business Rules
        private const val LANGUAGE = "en-US"
        private const val SORT_BY = "popularity.desc"
        private const val ADULT = "false"
        private const val PAGE = 1
        private const val RELEASE_YEAR = "2010"
    }
}

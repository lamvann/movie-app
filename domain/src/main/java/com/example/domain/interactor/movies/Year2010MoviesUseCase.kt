package com.example.domain.interactor.movies

import com.example.domain.entity.Movie
import com.example.domain.interactor.BaseUseCase
import com.example.domain.repository.movies.PopularMoviesRepository

class Year2010MoviesUseCase(private val repository: PopularMoviesRepository) : BaseUseCase<List<Movie>> {

    override suspend fun run(): Result<List<Movie>> {
        val movies = repository.get(
            language = LANGUAGE,
            sortBy = SORT_BY,
            includeAdult = ADULT,
            page = PAGE,
            genre = SCI_FI_GENRE
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
        private const val SCI_FI_GENRE = "878"
    }
}

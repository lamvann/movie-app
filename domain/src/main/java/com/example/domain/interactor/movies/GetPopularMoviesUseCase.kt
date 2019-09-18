package com.example.domain.interactor.movies

import com.example.domain.entity.Movie
import com.example.domain.interactor.BaseUseCase
import com.example.domain.repository.movies.PopularMoviesRepository

class GetPopularMoviesUseCase(private val repository: PopularMoviesRepository) : BaseUseCase<List<Movie>> {

    override suspend fun run(): Result<List<Movie>> {
        val movies = repository.get(LANGUAGE, SORT_BY, ADULT, PAGE)

        //todo: error handling


        return movies
    }


    companion object {
        // Business Rules
        private const val LANGUAGE = "en-US"
        private const val SORT_BY = "popularity.desc"
        private const val ADULT = "false"
        private const val PAGE = 1
    }
}

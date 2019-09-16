package com.example.domain.interactor.movies

import com.example.domain.Entity
import com.example.domain.repository.movies.PopularMoviesRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetPopularMoviesUseCaseImpl @Inject constructor(
    private val repository: PopularMoviesRepository
) : GetPopularMoviesUseCase {
    override operator fun invoke(): Observable<List<Entity.Movie>> =
        repository.get(LANGUAGE, SORT_BY, ADULT, PAGE)

    companion object {
        // Business Rules
        private const val LANGUAGE = "en-US"
        private const val SORT_BY = "popularity.desc"
        private const val ADULT = "false"
        private const val PAGE = 1
    }
}

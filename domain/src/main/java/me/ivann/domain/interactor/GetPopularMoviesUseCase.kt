package me.ivann.domain.interactor

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import me.ivann.domain.Entity
import me.ivann.domain.repository.PopularMoviesRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: PopularMoviesRepository
) {
    operator fun invoke(): Observable<Entity.PopularMovies> =
        repository.get(LANGUAGE, SORT_BY, ADULT, PAGE)
            .observeOn(AndroidSchedulers.mainThread())

    companion object {
        // Business Rules
        const val LANGUAGE = "en-US"
        const val SORT_BY = "popularity.desc"
        const val ADULT = "false"
        const val PAGE = 1
    }
}
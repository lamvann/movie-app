package me.ivann.movie.domain.interactor

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import me.ivann.movie.domain.Entity
import me.ivann.movie.domain.repository.PopularMoviesRepository
import javax.inject.Inject

/*
 * This is a crucial part of our app's architecture! See that this use case
 * contains our "business rules" and is asking the popular movie repository
 * to get some data.
 *
 * Note: This use case depends ONLY on an interface and we don't care how
 *       the repository chooses to get the data (as long as we get the data).
 *
 */

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

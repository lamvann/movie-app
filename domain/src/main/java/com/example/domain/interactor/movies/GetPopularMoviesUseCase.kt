package com.example.domain.interactor.movies

import com.example.domain.Entity
import com.example.domain.interactor.BaseUseCase
import io.reactivex.Observable

interface GetPopularMoviesUseCase : BaseUseCase {
    operator fun invoke(): Observable<List<Entity.Movie>>
}

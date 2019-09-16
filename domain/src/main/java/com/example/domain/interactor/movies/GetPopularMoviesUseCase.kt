package com.example.domain.interactor.movies

import com.example.domain.Entity
import com.example.domain.interactor.BaseUseCase

interface GetPopularMoviesUseCase : BaseUseCase {
    suspend operator fun invoke(): List<Entity.Movie>
}

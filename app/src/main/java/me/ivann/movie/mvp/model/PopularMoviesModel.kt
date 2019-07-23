package me.ivann.movie.mvp.model

import me.ivann.movie.domain.interactor.GetPopularMoviesUseCase
import javax.inject.Inject

class PopularMoviesModel @Inject constructor(
    val useCase: GetPopularMoviesUseCase
)
package com.example.presentation.ui.popular

import android.app.Application
import com.example.domain.interactor.Failure
import com.example.domain.interactor.movies.GetPopularMoviesUseCase
import com.example.presentation.ui.base.BaseViewModel
import com.example.presentation.ui.util.Constants.TEXT

class PopularMoviesViewModel(

    application: Application,
    private val popularMoviesUseCase: GetPopularMoviesUseCase

) : BaseViewModel<PopularMoviesUiModel>(application, PopularMoviesUiModel.default) {

    init {
        updateUiModel { uiModel ->
            uiModel.copy(onFetchButtonClicked = ::fetchMovies)
        }
    }

    override fun <F : Failure> onError(failure: F) {
        updateUiModel { uiModel -> uiModel.copy(isLoading = false, hasError = true) }
    }

    fun fetchMovies() {
        updateUiModel { uiModel -> uiModel.copy(isLoading = true) }

        launchUseCase(popularMoviesUseCase) { movies ->
            updateUiModel { uiModel ->
                uiModel.copy(
                    isLoading = false,
                    moviesText = movies.joinToString(
                        prefix = Typography.bullet.toString(),
                        separator = Typography.bullet.toString()
                    ) { TEXT.format(it.title, it.overview) }
                )
            }
        }
    }
}

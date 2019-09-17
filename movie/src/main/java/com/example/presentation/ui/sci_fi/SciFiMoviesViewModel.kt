package com.example.presentation.ui.sci_fi

import android.app.Application
import com.example.domain.interactor.Failure
import com.example.domain.interactor.movies.SciFiMoviesUseCase
import com.example.presentation.ui.base.BaseViewModel
import me.ivann.movie.util.Constants.TEXT
import kotlin.text.Typography.bullet

class SciFiMoviesViewModel(
    application: Application,
    private val sciFiMoviesUseCase: SciFiMoviesUseCase
) : BaseViewModel<SciFiMoviesUiModel>(application, SciFiMoviesUiModel.default) {

    init {
        updateUiModel { uiModel ->
            uiModel.copy(onFetchButtonClicked = ::fetchMovies)
        }
    }

    override fun <F : Failure> onError(failure: F) {
        updateUiModel { uiModel -> uiModel.copy(isLoading = false, hasError = true) }
    }

    private fun fetchMovies() {
        updateUiModel { uiModel -> uiModel.copy(isLoading = true) }

        launchUseCase(sciFiMoviesUseCase) { movies ->
            updateUiModel { uiModel ->
                uiModel.copy(
                    isLoading = false,
                    moviesText = movies.joinToString(
                        prefix = bullet.toString(),
                        separator = bullet.toString()
                    ) { TEXT.format(it.title, it.overview) }
                )
            }
        }
    }
}

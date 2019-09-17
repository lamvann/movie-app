package com.example.presentation.ui.year2010

import android.app.Application
import com.example.domain.interactor.Failure
import com.example.domain.interactor.movies.Year2010MoviesUseCase
import com.example.presentation.ui.base.BaseViewModel
import me.ivann.movie.util.Constants.TEXT

class Year2010ViewModel(
    application: Application,
    private val year2010MoviesUseCase: Year2010MoviesUseCase
) : BaseViewModel<Year2010UiModel>(application, Year2010UiModel.default) {

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

        launchUseCase(year2010MoviesUseCase) { movies ->
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

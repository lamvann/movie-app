package com.example.presentation.ui.popular

import android.app.Application
import com.example.domain.interactor.Failure
import com.example.domain.interactor.movies.GetPopularMoviesUseCase
import com.example.presentation.ui.base.BaseViewModel
import me.ivann.movie.util.Constants.TEXT

class PopularMoviesViewModel(
    application: Application,
    private val popularMoviesUseCase: GetPopularMoviesUseCase
) : BaseViewModel<PopularMoviesUiModel>(application, PopularMoviesUiModel.default) {

    override fun <F : Failure> onError(failure: F) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        updateUiModel { uiModel ->
            uiModel.copy(onFetchButtonClicked = ::fetchMovies)
        }
    }

    private fun fetchMovies() {
        launchUseCase(popularMoviesUseCase) { movies ->
            updateUiModel { uiModel ->
                uiModel.copy(moviesText = movies.joinToString { TEXT.format(it.title, it.overview) })
            }
        }
    }
}

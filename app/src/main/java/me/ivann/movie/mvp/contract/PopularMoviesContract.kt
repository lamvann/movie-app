package me.ivann.movie.mvp.contract

import me.ivann.movie.mvp.base.BasePresenter
import me.ivann.movie.util.AutoDisposable

interface PopularMoviesContract {

    interface View {
        fun setupListeners()

        fun updateText(content: String)
    }

    interface Presenter: BasePresenter<View> {
        fun getPopularMovies(autoDisposable: AutoDisposable)
    }
}

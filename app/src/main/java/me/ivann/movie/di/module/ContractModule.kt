package me.ivann.movie.di.module

import dagger.Binds
import dagger.Module
import me.ivann.movie.mvp.contract.PopularMoviesContract
import me.ivann.movie.mvp.presenter.PopularMoviesPresenter

@Module
abstract class ContractModule {
    // This module allows our presenters to be injected
    @Binds
    abstract fun providesPresenter(presenter: PopularMoviesPresenter): PopularMoviesContract.Presenter
}
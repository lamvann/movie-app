package me.ivann.movie.di.module

import dagger.Binds
import dagger.Module
import me.ivann.movie.ui.base.BaseActivity
import me.ivann.movie.ui.movies.PopularMoviesActivity

@Module
abstract class MovieActivityModule {

    @Binds
    abstract fun bindBaseActivity(activity: PopularMoviesActivity) : BaseActivity
}
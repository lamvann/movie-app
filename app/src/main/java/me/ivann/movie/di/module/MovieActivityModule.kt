package me.ivann.movie.di.module

import dagger.Binds
import dagger.Module
import me.ivann.movie.mvp.base.BaseActivity
import me.ivann.movie.mvp.view.PopularMoviesActivity

@Module
abstract class MovieActivityModule {

    @Binds
    abstract fun bindBaseActivity(activity: PopularMoviesActivity) : BaseActivity
}
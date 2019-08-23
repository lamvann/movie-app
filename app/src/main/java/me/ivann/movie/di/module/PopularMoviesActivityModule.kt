package me.ivann.movie.di.module

import dagger.Binds
import dagger.Module
import me.ivann.movie.databinding.ActivityMainBinding
import me.ivann.movie.ui.base.BaseActivity
import me.ivann.movie.ui.movies.PopularMoviesActivity
import me.ivann.movie.ui.movies.PopularMoviesViewModel

@Module
abstract class PopularMoviesActivityModule {

    @Binds
    abstract fun bindBaseActivity(activity: PopularMoviesActivity)
            : BaseActivity<PopularMoviesViewModel, ActivityMainBinding>
}
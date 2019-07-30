package me.ivann.movie.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.ivann.movie.mvp.view.PopularMoviesActivity

@Module
abstract class ActivityBindingModule {
    /*
    Binds PopularMoviesActivity in another module as a BaseActivity so that BaseActivity can be injected
    with the objects that its subclasses will use.
    Such as the AutoDisposable
     */
    @ContributesAndroidInjector(modules = [PopularMoviesActivityModule::class])
    abstract fun bindMovieActivity(): PopularMoviesActivity
}

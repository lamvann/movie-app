package me.ivann.movie.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.ivann.movie.mvp.view.PopularMoviesActivity

@Module
abstract class ActivityBindingModule {
    /*
    Binds LoadShipActivity in another module as a BaseActivity so that BaseActivity can be injected
    with the objects that its subclasses will use.

    Such as the AutoDisposable

     */
    @ContributesAndroidInjector(modules = [MovieActivityModule::class])
    abstract fun bindMovieActivity(): PopularMoviesActivity
}

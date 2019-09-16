package me.ivann.movie.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.example.presentation.ui.movies.PopularMoviesActivity

@Module
abstract class ActivityBindingModule {
    /*
    Binds LoadShipActivity in another module as a BaseActivity so that BaseActivity can be injected
    with the objects that its subclasses will use.

    Such as the AutoDisposable

     */
    @ContributesAndroidInjector(
        modules = [PopularMoviesActivityModule::class, ViewModelModule::class]
    )
    abstract fun bindMovieActivity(): PopularMoviesActivity
}

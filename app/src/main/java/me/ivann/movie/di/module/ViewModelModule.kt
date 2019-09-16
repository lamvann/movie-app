package me.ivann.movie.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.ivann.movie.di.annotation.ViewModelKey
import me.ivann.movie.ui.ViewModelFactory
import com.example.presentation.ui.movies.PopularMoviesViewModel

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PopularMoviesViewModel::class)
    abstract fun bindPopularMoviesViewModel(viewModel: PopularMoviesViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}

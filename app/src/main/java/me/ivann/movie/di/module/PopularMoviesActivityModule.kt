package me.ivann.movie.di.module

import com.example.domain.interactor.movies.GetPopularMoviesUseCase
import com.example.domain.interactor.movies.GetPopularMoviesUseCaseImpl
import com.example.presentation.databinding.ActivityMainBinding
import dagger.Binds
import dagger.Module
import me.ivann.movie.ui.base.BaseActivity
import com.example.presentation.ui.movies.PopularMoviesActivity
import com.example.presentation.ui.movies.PopularMoviesViewModel

@Module
abstract class PopularMoviesActivityModule {

    @Binds
    abstract fun bindBaseActivity(activity: PopularMoviesActivity)
            : BaseActivity<PopularMoviesViewModel, ActivityMainBinding>

    @Binds
    abstract fun bindUseCase(useCase: GetPopularMoviesUseCaseImpl): GetPopularMoviesUseCase
}
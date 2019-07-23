package me.ivann.movie.di.module

import dagger.Binds
import dagger.Module
import me.ivann.movie.data.respository.PopularMoviesRepositoryImpl
import me.ivann.movie.domain.repository.PopularMoviesRepository

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindsPopularMoviesRepository (repository: PopularMoviesRepositoryImpl): PopularMoviesRepository
}
package me.ivann.movie.di.module

import dagger.Binds
import dagger.Module
import me.ivann.movie.data.service.PopularMoviesServiceImpl
import me.ivann.movie.domain.service.PopularMoviesService

@Module
abstract class ServiceModule {
    @Binds
    abstract fun providesPopularMoviesService(service: PopularMoviesServiceImpl): PopularMoviesService
}
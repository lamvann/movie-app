package me.ivann.movie.di.module

import com.example.domain.service.PopularMoviesService
import dagger.Binds
import dagger.Module
import me.ivann.movie.data.service.PopularMoviesServiceImpl

@Module
abstract class ServiceModule {
    @Binds
    abstract fun providesPopularMoviesService(service: PopularMoviesServiceImpl): PopularMoviesService
}
package me.ivann.movie.di.module

import com.example.domain.repository.movies.PopularMoviesRepository
import dagger.Binds
import dagger.Module
import me.ivann.movie.data.respository.PopularMoviesRepositoryImpl

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindsPopularMoviesRepository (repository: PopularMoviesRepositoryImpl): PopularMoviesRepository
}
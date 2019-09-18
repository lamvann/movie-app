package me.ivann.movie.data.di

import com.example.domain.repository.movies.PopularMoviesRepository
import com.example.domain.service.PopularMoviesService
import me.ivann.movie.data.api.MovieApi
import me.ivann.movie.data.respository.PopularMoviesRepositoryImpl
import me.ivann.movie.data.service.PopularMoviesServiceImpl
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

const val BASE_URL = "https://api.themoviedb.org/3/"

val dataModule: Module = module(createdAtStart = true, override = true) {

    factory<PopularMoviesRepository> { PopularMoviesRepositoryImpl(get()) }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single<MovieApi> { get<Retrofit>().create() }
    single<PopularMoviesService> { PopularMoviesServiceImpl(get()) }
}
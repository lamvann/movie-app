package com.example.domain.di

import com.example.domain.interactor.movies.GetPopularMoviesUseCase
import com.example.domain.interactor.movies.SciFiMoviesUseCase
import com.example.domain.interactor.movies.Year2010MoviesUseCase
import com.example.domain.repository.movies.PopularMoviesRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val domainModule: Module = module(createdAtStart = true, override = true) {
    single { GetPopularMoviesUseCase(get()) }
    single { SciFiMoviesUseCase(get()) }
    single { Year2010MoviesUseCase(get()) }
}
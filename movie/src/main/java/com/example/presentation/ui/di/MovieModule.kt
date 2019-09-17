package com.example.presentation.ui.di

import com.example.presentation.ui.popular.PopularMoviesViewModel
import com.example.presentation.ui.sci_fi.SciFiMoviesViewModel
import com.example.presentation.ui.year2010.Year2010ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val movieModule: Module = module(createdAtStart = true, override = true) {

    viewModel { SciFiMoviesViewModel(get(), get()) }
    viewModel { PopularMoviesViewModel(get(), get()) }
    viewModel { Year2010ViewModel(get(), get()) }
}
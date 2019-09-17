package com.example.presentation.ui.movies

import com.example.presentation.ui.base.UiModel

data class PopularMoviesUiModel(
    override val hasError: Boolean,
    override val isLoading: Boolean,
    val moviesText: String,
    val onFetchButtonClicked: () -> Unit
) : UiModel {

    companion object {
        val default: PopularMoviesUiModel = PopularMoviesUiModel(
            hasError = false,
            isLoading = true,
            moviesText = "",
            onFetchButtonClicked = {}
        )
    }

}
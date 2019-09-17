package com.example.presentation.ui.popular

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
            isLoading = false,
            moviesText = "",
            onFetchButtonClicked = {}
        )
    }

}
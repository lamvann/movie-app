package com.example.presentation.ui.sci_fi

import com.example.presentation.ui.base.UiModel

data class SciFiMoviesUiModel(
    override val hasError: Boolean,
    override val isLoading: Boolean,
    val moviesText: String,
    val onFetchButtonClicked: () -> Unit
) : UiModel {

    companion object {
        val default: SciFiMoviesUiModel = SciFiMoviesUiModel(
            hasError = false,
            isLoading = false,
            moviesText = "",
            onFetchButtonClicked = {}
        )
    }

}
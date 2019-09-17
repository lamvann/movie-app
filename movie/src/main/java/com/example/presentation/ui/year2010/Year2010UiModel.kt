package com.example.presentation.ui.year2010

import com.example.presentation.ui.base.UiModel

data class Year2010UiModel(
    override val hasError: Boolean,
    override val isLoading: Boolean,

    val moviesText: String,
    val onFetchButtonClicked: () -> Unit

) : UiModel {

    companion object {
        val default: Year2010UiModel = Year2010UiModel(
            hasError = false,
            isLoading = false,
            moviesText = "",
            onFetchButtonClicked = {}
        )
    }

}
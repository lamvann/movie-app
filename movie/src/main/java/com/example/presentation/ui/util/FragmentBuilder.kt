package com.example.presentation.ui.util

interface FragmentBuilder<T> {
    fun newInstance(vararg arguments: Pair<String, Any>): T
}
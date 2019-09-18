package com.example.presentation.ui.util

import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible", "setInvisibleOnFalse", requireAll = false)
fun View.setIsVisible(viewIsVisible: Boolean, setInvisibleOnFalse: Boolean = false) {
    if (isVisible != viewIsVisible) {
        if (setInvisibleOnFalse) {
            isInvisible = viewIsVisible.not()
        } else {
            isVisible = viewIsVisible
        }
    }
}
@BindingAdapter("onClick")
fun View.setOnClickLambda(onClick: () -> Unit) {
    setOnClickListener { onClick() }
}
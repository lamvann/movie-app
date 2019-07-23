package me.ivann.movie.util.extension

import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity

fun <T : View> AppCompatActivity.bindView(@IdRes idRes: Int): Lazy<T> =
    lazyUnsychronized {
        findViewById<T>(idRes)
    }
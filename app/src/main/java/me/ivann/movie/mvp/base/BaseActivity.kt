package me.ivann.movie.mvp.base

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import me.ivann.movie.util.AutoDisposable
import javax.inject.Inject

abstract class BaseActivity: DaggerAppCompatActivity() {

    @Inject lateinit var autoDisposable: AutoDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoDisposable.bindTo(this.lifecycle)
    }
}

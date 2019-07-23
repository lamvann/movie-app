package me.ivann.movie.mvp.base

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import dagger.android.support.DaggerAppCompatActivity
import me.ivann.movie.util.AutoDisposable
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject lateinit var autoDisposable: AutoDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoDisposable.bindTo(this.lifecycle)
    }

    fun hideTop() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
    }

}

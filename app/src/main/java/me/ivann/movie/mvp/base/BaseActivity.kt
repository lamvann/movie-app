package me.ivann.movie.mvp.base

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import dagger.android.support.DaggerAppCompatActivity
import me.ivann.movie.util.AutoDisposable
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    // This can be injected with Dagger2
    var autoDisposable = AutoDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoDisposable.bindTo(this.lifecycle)
    }
}

package me.ivann.movie.ui.movies

import android.os.Bundle
import androidx.lifecycle.Observer
import me.ivann.movie.ui.base.BaseActivity
import org.jetbrains.anko.setContentView


class PopularMoviesActivity : BaseActivity<PopularMoviesViewModel>() {

    private val ui by lazy { PopularMoviesUI() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
        viewModel.movieData.observe(this, Observer {
            updateText(it)
        })
    }

    private fun updateText(content: String) {
        ui.tvMainText.text = content
    }
}

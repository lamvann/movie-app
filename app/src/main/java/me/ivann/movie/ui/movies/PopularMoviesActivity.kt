package me.ivann.movie.ui.movies

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import me.ivann.movie.R
import me.ivann.movie.ui.base.BaseActivity
import me.ivann.movie.util.extension.bindView


class PopularMoviesActivity : BaseActivity<PopularMoviesViewModel>() {

    private val tvMainText: TextView by bindView(R.id.mainText)
    private val btnGetMovies: Button by bindView(R.id.mainButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener()
        viewModel.movieData.observe(this, Observer {
            updateText(it)
        })
    }

    private fun setupListener() =
        btnGetMovies.setOnClickListener {
            viewModel.getPopularMovies(autoDisposable)
        }

    private fun updateText(content: String) {
        tvMainText.text = content
    }
}

package me.ivann.movie.ui.movies

import android.os.Bundle
import me.ivann.movie.R
import me.ivann.movie.databinding.ActivityMainBinding
import me.ivann.movie.ui.base.BaseActivity

class PopularMoviesActivity : BaseActivity<PopularMoviesViewModel, ActivityMainBinding>() {

    override var layout = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.autoDisposable = autoDisposable
    }
}

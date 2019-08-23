package me.ivann.movie.ui.movies

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import me.ivann.movie.R
import me.ivann.movie.databinding.ActivityMainBinding
import me.ivann.movie.ui.base.BaseActivity

class PopularMoviesActivity : BaseActivity<PopularMoviesViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.autoDisposable = autoDisposable
    }
}

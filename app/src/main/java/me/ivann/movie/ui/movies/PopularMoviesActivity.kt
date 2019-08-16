package me.ivann.movie.ui.movies

import android.os.Bundle
import me.ivann.movie.mvp.contract.PopularMoviesContract
import me.ivann.movie.mvp.presenter.PopularMoviesPresenter
import me.ivann.movie.ui.base.BaseActivity
import org.jetbrains.anko.setContentView
import javax.inject.Inject

class PopularMoviesActivity : BaseActivity(), PopularMoviesContract.View {

    val ui: PopularMoviesUI by lazy { PopularMoviesUI() }

    @Inject lateinit var presenter: PopularMoviesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui.setContentView(this)
        presenter.attach(this)
    }

    override fun updateText(content: String) {
        ui.tvMainText.text = content
    }
}

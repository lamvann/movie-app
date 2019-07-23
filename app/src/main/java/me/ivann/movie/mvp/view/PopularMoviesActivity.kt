package me.ivann.movie.mvp.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import me.ivann.movie.R
import me.ivann.movie.mvp.base.BaseActivity
import me.ivann.movie.mvp.contract.PopularMoviesContract
import me.ivann.movie.mvp.presenter.PopularMoviesPresenter
import me.ivann.movie.util.extension.bindView
import javax.inject.Inject

class PopularMoviesActivity : BaseActivity(), PopularMoviesContract.View {

    private val tvMainText: TextView by bindView(R.id.mainText)
    private val btnMainButton: Button by bindView(R.id.mainButton)

    @Inject lateinit var presenter: PopularMoviesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attach(this)
        setupListeners()
    }

    override fun setupListeners() =
        btnMainButton.setOnClickListener {
            presenter.getPopularMovies(autoDisposable)
        }

    override fun updateText(content: String) {
        tvMainText.text = content
    }
}

package me.ivann.movie.ui.movies

import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.sdk25.coroutines.onClick

class PopularMoviesUI : AnkoComponent<PopularMoviesActivity> {

    lateinit var tvMainText: TextView
    lateinit var btnFetchPopularMovies: Button
    lateinit var svMainArea: ScrollView

    override fun createView(ui: AnkoContext<PopularMoviesActivity>) = with(ui) {

        val activity = owner

        constraintLayout {
            svMainArea = scrollView {
                tvMainText = textView("Hello world!").lparams {
                    width = matchParent ; height = matchParent
                    bottomPadding = dip(55)
                }
            }.lparams {
                topToTop = PARENT_ID
                bottomToBottom = PARENT_ID
                rightToRight = PARENT_ID
                leftToLeft = PARENT_ID
            }

            btnFetchPopularMovies = button("Fetch Popular movies") {
                onClick { activity.presenter.getPopularMovies(activity.autoDisposable) }
            }.lparams {
                bottomToBottom = PARENT_ID
                rightToRight = PARENT_ID
                leftToLeft = PARENT_ID
            }
        }
    }
}

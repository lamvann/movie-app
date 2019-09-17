package com.example.presentation.ui.base

import android.content.Intent
import android.os.Bundle
import com.example.presentation.R
import com.example.presentation.ui.di.MovieFragmentFactory
import com.example.presentation.ui.popular.PopularMoviesFragment
import com.example.presentation.ui.sci_fi.SciFiMoviesFragment
import com.example.presentation.ui.year2010.Year2010Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ncapdevi.fragnav.FragNavController
import com.ncapdevi.fragnav.FragNavTransactionOptions

class MoviesActivity : BaseActivity(R.layout.activity) {

    val fragmentFactory: MovieFragmentFactory by lazy { MovieFragmentFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = fragmentFactory

        super.onCreate(savedInstanceState)

        fragNavController.rootFragments = listOf(
            fragmentFactory.createFragment<SciFiMoviesFragment>(),
            fragmentFactory.createFragment<PopularMoviesFragment>(),
            fragmentFactory.createFragment<Year2010Fragment>()
        )

        fragNavController.initialize(FragNavController.TAB2, savedInstanceState)

        initBottomNavigationBar()
    }

    private fun initBottomNavigationBar() {
        findViewById<BottomNavigationView>(R.id.navigation).run {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.navigation_sci_fi -> fragNavController.switchTab(
                        FragNavController.TAB1,
                        FragNavTransactionOptions.newBuilder()
                            .customAnimations(
                                android.R.anim.slide_in_left,
                                android.R.anim.slide_out_right,
                                android.R.anim.slide_in_left,
                                android.R.anim.slide_out_right
                            ).build()
                    )
                    R.id.navigation_popular -> fragNavController.switchTab(
                        FragNavController.TAB2,
                        FragNavTransactionOptions.newBuilder()
                            .customAnimations(
                                android.R.anim.fade_in,
                                android.R.anim.fade_out,
                                android.R.anim.fade_in,
                                android.R.anim.fade_out
                            ).build()
                    )
                    R.id.navigation_2010 -> fragNavController.switchTab(
                        FragNavController.TAB3,
                        FragNavTransactionOptions.newBuilder()
                            .customAnimations(
                                android.R.anim.fade_in,
                                android.R.anim.slide_out_right,
                                android.R.anim.fade_in,
                                android.R.anim.slide_out_right
                            ).build()
                    )
                }
                true
            }
            selectedItemId = R.id.navigation_popular
        }
    }
}
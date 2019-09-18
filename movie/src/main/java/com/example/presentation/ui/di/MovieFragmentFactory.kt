package com.example.presentation.ui.di

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.presentation.ui.base.BaseFragment
import com.example.presentation.ui.popular.PopularMoviesFragment
import com.example.presentation.ui.sci_fi.SciFiMoviesFragment
import com.example.presentation.ui.year2010.Year2010Fragment
import org.koin.core.KoinComponent
import org.koin.core.get
import java.lang.IllegalArgumentException


class MovieFragmentFactory : FragmentFactory(), KoinComponent {

    fun instantiate(classLoader: ClassLoader, className: String, args: Bundle?): Fragment {

        loadFragmentClass(classLoader, className)

        val fragment = when (loadFragmentClass(classLoader, className)) {
            PopularMoviesFragment::class.java -> PopularMoviesFragment.newInstance(get())

            SciFiMoviesFragment::class.java -> SciFiMoviesFragment.newInstance(get())
            Year2010Fragment::class.java -> Year2010Fragment.newInstance(get())
            else -> return super.instantiate(classLoader, className)
        }

        fragment.setArguments(args ?: bundleOf())

        return fragment
    }

    inline fun <reified T : BaseFragment> createFragment(args: Bundle? = null): T {
        val fragmentClass = loadFragmentClass(T::class.java.classLoader!!, T::class.java.name) as Class<T>
        return createFragment(fragmentClass, args)
    }

    inline fun <reified T : BaseFragment> createFragment(clazz: Class<T>, args: Bundle?): T {
        val fragment = when (clazz) {
            PopularMoviesFragment::class.java -> PopularMoviesFragment.newInstance(get())
            SciFiMoviesFragment::class.java -> SciFiMoviesFragment.newInstance(get())
            Year2010Fragment::class.java -> Year2010Fragment.newInstance(get())
            else -> throw IllegalArgumentException("No Fragment found for class ${T::class.java}")
        }

        fragment.setArguments(args ?: bundleOf())

        return fragment as T
    }
}
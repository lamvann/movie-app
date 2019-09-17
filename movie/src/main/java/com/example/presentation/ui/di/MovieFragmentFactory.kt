package com.example.presentation.ui.di

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory.loadFragmentClass
import androidx.fragment.app.FragmentFactory
import com.example.presentation.ui.popular.PopularMoviesFragment
import com.example.presentation.ui.sci_fi.SciFiMoviesFragment
import com.example.presentation.ui.year2010.Year2010Fragment


class FragmentFactoryImpl() : FragmentFactory() {


    @NonNull
    fun instantiate(@NonNull classLoader: ClassLoader, @NonNull className: String, @Nullable args: Bundle?): Fragment {
        val clazz = loadFragmentClass(classLoader, className)

        val fragment = when (clazz) {
            PopularMoviesFragment::class.java -> PopularMoviesFragment.newInstance()
            SciFiMoviesFragment::class.java -> PopularMoviesFragment.newInstance()
            Year2010Fragment::class.java -> Year2010Fragment.newInstance()
        }

        if (clazz == PopularMoviesFragment::class.java) {
            fragment = PopularMoviesFragment(mDep1Factory.newInstance(), mDep2Factory.newInstance())
        } else {
            return super.instantiate(classLoader, className, args)
        }

        if (args != null) {
            fragment!!.setArguments(args)
        }

        return fragment
    }
}
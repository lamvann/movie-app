package com.example.presentation.ui.movies

import com.example.presentation.R
import com.example.presentation.databinding.FragmentMoviesBinding
import com.example.presentation.ui.base.BaseDataBindingFragment
import com.example.presentation.ui.util.FragmentBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularMoviesFragment : BaseDataBindingFragment<
        PopularMoviesUiModel,
        PopularMoviesViewModel,
        FragmentMoviesBinding>(R.layout.fragment_movies) {

    override val viewModel: PopularMoviesViewModel by viewModel()

    override fun onUiModelUpdated(uiModel: PopularMoviesUiModel) {
        super.onUiModelUpdated(uiModel)
        //todo - do stuff
    }

    companion object Builder: FragmentBuilder<PopularMoviesFragment> {
        override fun newInstance(vararg arguments: Pair<String, Any>): PopularMoviesFragment {
            return PopularMoviesFragment()
        }
    }

}
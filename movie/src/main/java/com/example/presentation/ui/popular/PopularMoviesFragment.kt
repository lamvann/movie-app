package com.example.presentation.ui.popular

import com.example.presentation.R
import com.example.presentation.databinding.FragmentPopularMoviesBinding
import com.example.presentation.ui.base.BaseDataBindingFragment
import com.example.presentation.ui.util.FragmentBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class PopularMoviesFragment(override val viewModel: PopularMoviesViewModel) : BaseDataBindingFragment<
        PopularMoviesUiModel,
        PopularMoviesViewModel,
        FragmentPopularMoviesBinding>(R.layout.fragment_popular_movies) {

//    override val viewModel: PopularMoviesViewModel by viewModel()

    override fun onViewStart() {
        super.onViewStart()
//        Timber.d("Arguments: $argument")
    }

    override fun onUiModelUpdated(uiModel: PopularMoviesUiModel) {
        super.onUiModelUpdated(uiModel)
        //todo - do stuff
    }

    companion object Builder {
        fun newInstance(viewModel: PopularMoviesViewModel): PopularMoviesFragment {
            return PopularMoviesFragment(viewModel)
        }
    }

}
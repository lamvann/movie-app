package com.example.presentation.ui.sci_fi

import com.example.presentation.R
import com.example.presentation.databinding.FragmentSciFiMoviesBinding
import com.example.presentation.ui.base.BaseDataBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class SciFiMoviesFragment(override val viewModel: SciFiMoviesViewModel) : BaseDataBindingFragment<
        SciFiMoviesUiModel,
        SciFiMoviesViewModel,
        FragmentSciFiMoviesBinding>(R.layout.fragment_sci_fi_movies) {

    override fun onUiModelUpdated(uiModel: SciFiMoviesUiModel) {
        super.onUiModelUpdated(uiModel)
        Timber.d("This is the current text: ${uiModel.moviesText}")
        Timber.d("This is the current loading visibility: ${uiModel.isLoading}")
    }

    companion object Builder {
        fun newInstance(viewModel: SciFiMoviesViewModel): SciFiMoviesFragment {
            return SciFiMoviesFragment(viewModel)
        }
    }
}
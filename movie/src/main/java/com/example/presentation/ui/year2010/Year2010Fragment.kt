package com.example.presentation.ui.year2010

import com.example.presentation.R
import com.example.presentation.databinding.Fragment2010MoviesBinding
import com.example.presentation.ui.base.BaseDataBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class Year2010Fragment(override val viewModel: Year2010ViewModel) : BaseDataBindingFragment<
        Year2010UiModel,
        Year2010ViewModel,
        Fragment2010MoviesBinding>(R.layout.fragment_2010_movies) {

    override fun onUiModelUpdated(uiModel: Year2010UiModel) {
        super.onUiModelUpdated(uiModel)
        Timber.d("This is the current text: ${uiModel.moviesText}")
        Timber.d("This is the current loading visibility: ${uiModel.isLoading}")
    }

    companion object Builder {
        fun newInstance(viewModel: Year2010ViewModel): Year2010Fragment {
            return Year2010Fragment(viewModel)
        }
    }

}
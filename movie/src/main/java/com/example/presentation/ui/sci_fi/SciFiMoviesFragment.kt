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

//    override val viewModel: SciFiMoviesViewModel by viewModel()

    override fun onViewStart() {
        super.onViewStart()
//        Timber.d("Arguments: $sampleArgument")
    }

    override fun onUiModelUpdated(uiModel: SciFiMoviesUiModel) {
        super.onUiModelUpdated(uiModel)
        //todo - do stuff
    }

    companion object Builder {
        fun newInstance(viewModel: SciFiMoviesViewModel): SciFiMoviesFragment {
            return SciFiMoviesFragment(viewModel)
        }
    }
}
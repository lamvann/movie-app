package com.example.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.presentation.BR
import timber.log.Timber

abstract class BaseDataBindingFragment<
        UiModelType : UiModel,
        ViewModelType : BaseViewModel<UiModelType>,
        BindingType : ViewDataBinding>(@LayoutRes val layoutId: Int) : BaseFragment(layoutId) {

    protected lateinit var binding: BindingType

    abstract val viewModel: ViewModelType
    val uiModel: UiModelType get() = viewModel.uiModel

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onArgumentsReceived(arguments ?: Bundle())
    }

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        onViewStart()
        bindUiModelLiveData()
    }

    private fun bindUiModelLiveData() {
        viewModel.uiModelLiveData.observe { uiModel ->
            uiModel as? UiModelType ?: throw IllegalStateException("Wrong UiModel type")
            Timber.d("Observed UiModel $uiModel")
            onUiModelUpdated(uiModel)
        }
    }

    open fun onUiModelUpdated(uiModel: UiModelType) {}

    @CallSuper
    open fun onViewStart() {
        binding.setVariable(BR.uiModel, viewModel.uiModelLiveData)
    }
}

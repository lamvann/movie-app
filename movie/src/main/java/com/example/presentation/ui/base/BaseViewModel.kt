package com.example.presentation.ui.base

import android.app.Application
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.interactor.BaseUseCase
import com.example.domain.interactor.Failure
import kotlinx.coroutines.launch

/**
 * Created by MRea on 8/9/2019.
 */
abstract class BaseViewModel<UiModelType : UiModel>(
    application: Application,
    uiModel: UiModelType
) : AndroidViewModel(application) {

    val uiModel: UiModelType
        get() = uiModelLiveData.value ?: throw IllegalStateException("UiModel is null")

    protected val _uiModelLiveData: MutableLiveData<UiModelType> = MutableLiveData()
    val uiModelLiveData: LiveData<UiModelType> get() = _uiModelLiveData

    init {
        _uiModelLiveData.value = uiModel
    }

    open fun onArgumentsReceived(arguments: Bundle) {}

    protected fun updateUiModel(update: (UiModelType) -> UiModelType) {
        uiModelLiveData.value?.let {
            val newModel = update(it)

            if (newModel === uiModelLiveData.value) throw IllegalStateException("UiModel is the same object. Use .copy")

            _uiModelLiveData.value = newModel
        } ?: throw IllegalStateException("UiModel is null")
    }

    fun <T : Any> launchUseCase(useCase: BaseUseCase<T>, onSuccess: (T) -> Unit) {
        viewModelScope.launch {
            useCase().fold(onFailure = { onError(it as Failure) }, onSuccess = { onSuccess(it) })
        }
    }

    abstract fun <F : Failure> onError(failure: F)

    fun getString(@StringRes resId: Int, vararg formatArgs: Any): String =
        getApplication<Application>().getString(resId, *formatArgs)
}

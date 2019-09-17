package com.example.presentation.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    var activity: BaseActivity? = null

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDetach() {
        activity = null
        super.onDetach()
    }

    fun <T> LiveData<T>.observe(onChange: (T) -> Unit) {
        observe(viewLifecycleOwner, Observer<T> { t -> onChange(t) })
    }
}

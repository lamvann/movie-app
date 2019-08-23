package me.ivann.movie.ui.base

import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import me.ivann.movie.ui.ViewModelFactory
import me.ivann.movie.util.AutoDisposable
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseActivity<VM : ViewModel, B : ViewDataBinding>
    : DaggerAppCompatActivity()
{
    @Inject lateinit var viewModelFactory: ViewModelFactory
    @Inject lateinit var autoDisposable: AutoDisposable

    @get:LayoutRes abstract var layout: Int

    @Suppress("UNCHECKED_CAST")
    private val viewModelClass =
        (javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[FIRST_ITEM] as Class<VM>

    val viewModel: VM
        by lazy {
            Log.e("BaseActivity", "Called ViewModelProviders.of")
            ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
        }

    val binding: B
        by lazy { DataBindingUtil.setContentView(this, layout) as B }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoDisposable.bindTo(this.lifecycle)
        binding.lifecycleOwner = this
    }

    companion object {
        private const val FIRST_ITEM = 0
    }
}

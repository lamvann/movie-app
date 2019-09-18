package com.example.presentation.ui.util

import androidx.lifecycle.*

fun <T> LiveData<T>.observeTest(onChangeHandler: (T) -> Unit) {
    val observer = TestObserver(handler = onChangeHandler)
    observe(observer, observer)
}

class TestObserver<T>(private val handler: (T) -> Unit) : Observer<T>, LifecycleOwner {
    private val lifecycle = LifecycleRegistry(this)

    init {
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun getLifecycle(): Lifecycle = lifecycle

    override fun onChanged(t: T) {
        handler(t)
    }
}

/**
 *  Observes all *new* values from this LiveData and adds them to @param list
 *  This function drops the first value from the LiveData (old value)
 */
fun <T> LiveData<T>.collectNewValues(list: MutableList<T>) {
    var hasSeenFirstValue = false
    observeTest {
        if (hasSeenFirstValue) {
            list += it
        } else {
            hasSeenFirstValue = true
        }
    }
}
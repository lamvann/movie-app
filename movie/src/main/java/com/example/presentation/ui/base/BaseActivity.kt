package com.example.presentation.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentActivity
import com.example.presentation.R
import com.ncapdevi.fragnav.FragNavController

abstract class BaseActivity(@LayoutRes layoutId: Int) : AppCompatActivity(layoutId) {

    protected val fragNavController: FragNavController = FragNavController(supportFragmentManager, R.id.fragment)
}

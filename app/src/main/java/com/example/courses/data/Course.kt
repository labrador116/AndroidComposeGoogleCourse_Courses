package com.example.courses.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val name: Int,
    val grain: Int,
    @DrawableRes val resId: Int,
)

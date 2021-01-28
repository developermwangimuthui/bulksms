package com.intelligentsoftwares.bulksms.util

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable



fun Drawable.applyColor(color: Int) {
    this.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
}
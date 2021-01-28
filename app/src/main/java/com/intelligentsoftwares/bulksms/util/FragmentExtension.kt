package com.intelligentsoftwares.bulksms.util

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment


/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */

fun Fragment.getMutedColor(@ColorRes color: Int) = requireActivity().getMutedColor(color)

fun Fragment.getResourceString(@StringRes stringResource: Int): String =
    requireActivity().getResourceString(stringResource)

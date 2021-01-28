package com.intelligentsoftwares.bulksms.activities.main.fragments

import android.os.Bundle

import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_splash_screen.*
import com.intelligentsoftwares.bulksms.R
import com.intelligentsoftwares.bulksms.enums.TypeFaceEnum
import com.intelligentsoftwares.bulksms.fragments.BaseFragment
import com.intelligentsoftwares.bulksms.util.getTypeface

/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */

class SplashScreenFragment : BaseFragment() {

    companion object {
        fun getInstance() = SplashScreenFragment()
    }

    override fun getLayoutResId() = R.layout.fragment_splash_screen

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        splashScreenLogoImageView.setImageResource(R.drawable.pro_sms_sender_logo)
        requireActivity().getTypeface(TypeFaceEnum.WELCOME_MESSAGE_TYPEFACE).also {
            splashScreenWelcomeMessageTextView.typeface = it
        }
    }

    override fun inOnCreateView(mRootView: View, container: ViewGroup?, savedInstanceState: Bundle?) {
    }
}

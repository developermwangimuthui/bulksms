package com.intelligentsoftwares.bulksms.activities.main.fragments.mainScreen.tabFragments

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.intelligentsoftwares.bulksms.R
import com.intelligentsoftwares.bulksms.fragments.BaseFragment


/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */
class AboutFragment : BaseFragment(){

    companion object {
        fun getInstance() = AboutFragment()
    }

    override fun getLayoutResId() = R.layout.fragment_about

    override fun inOnCreateView(mRootView: View, container: ViewGroup?, savedInstanceState: Bundle?) {
    }
}
package com.intelligentsoftwares.bulksms.activities.main.fragments.mainScreen.ui

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main_screen.*
import com.intelligentsoftwares.bulksms.R
import com.intelligentsoftwares.bulksms.activities.main.fragments.mainScreen.adapter.MainViewPagerAdapter
import com.intelligentsoftwares.bulksms.fragments.BaseFragment
import com.intelligentsoftwares.bulksms.util.SendBulkSmsActivityArgs

/**
 * Mwangi Muthui}
 * intelligentsoftwaresdev@gmail.com}
 * 6/26/19}
 */

class MainScreenFragment : BaseFragment() {

    companion object {
        fun getInstance() = MainScreenFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainScreenSendSmsFloatingActionButton.setOnClickListener {
            SendBulkSmsActivityArgs().launch(requireContext())
        }
        MainViewPagerAdapter(requireActivity().supportFragmentManager).also {
            mainScreenViewPager.adapter = it
        }
        mainScreenViewPager.apply {
            currentItem = 1
            offscreenPageLimit = 2
        }.also { mainScreenTabLayout.setupWithViewPager(it) }
    }

    override fun getLayoutResId() = R.layout.fragment_main_screen

    override fun inOnCreateView(
        mRootView: View, container: ViewGroup?, savedInstanceState: Bundle?
    ) {
    }
}
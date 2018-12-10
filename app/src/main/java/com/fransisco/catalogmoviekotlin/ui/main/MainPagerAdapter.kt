package com.fransisco.catalogmoviekotlin.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.fransisco.catalogmoviekotlin.ui.trending.TrendingFragment
import com.fransisco.catalogmoviekotlin.ui.topRated.TopRatedFragment

class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private var tabCount = 0

    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> TrendingFragment.newInstance()
            1 -> TopRatedFragment.newInstance()
            else -> null
        }
    }

    internal fun setCount(count: Int) {
        this.tabCount = count
    }

}
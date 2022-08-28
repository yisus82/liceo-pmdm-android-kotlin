package com.liceolapaz.des.jprf.appbar3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MiFragmentStateAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    companion object {
        const val PAGE_COUNT = 6
    }

    private val tabTitles = arrayOf("Tab Uno", "Tab Dos", "Tab Tres", "Tab Cuatro", "Tab Cinco", "Tab Seis")

    fun getTabTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }

    override fun getItemCount(): Int {
        return PAGE_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0,2,4 -> Fragment1()
            else -> Fragment2()
        }
    }
}
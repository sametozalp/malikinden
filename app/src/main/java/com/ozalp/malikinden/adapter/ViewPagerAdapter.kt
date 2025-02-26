package com.ozalp.malikinden.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ozalp.malikinden.fragment.DescriptionFragment
import com.ozalp.malikinden.fragment.ListingDetailFragment

class ViewPagerAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {
    private val fragments = listOf(ListingDetailFragment(), DescriptionFragment())

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
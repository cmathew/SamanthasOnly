package com.cmathew.samanthasonly

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MemoryPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
	override fun getItem(position: Int): Fragment {
		return MemoryFragment.newInstance("https://amithebomb.com")
	}

	override fun getCount(): Int {
		// Show 3 total pages.
		return 3
	}
}
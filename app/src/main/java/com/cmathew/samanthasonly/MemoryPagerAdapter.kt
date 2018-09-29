package com.cmathew.samanthasonly

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MemoryPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
	override fun getItem(position: Int): Fragment {
		return MemoryFragment.newInstance("https://amithebomb.com")
	}

	override fun getCount(): Int {
		// Show 3 total pages.
		return 3
	}
}
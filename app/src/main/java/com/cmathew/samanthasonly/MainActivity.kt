package com.cmathew.samanthasonly

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
	private lateinit var mSectionsPagerAdapter: MemoryPagerAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)

		mSectionsPagerAdapter = MemoryPagerAdapter(supportFragmentManager)
		container.adapter = mSectionsPagerAdapter
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		menuInflater.inflate(R.menu.menu_main, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		val id = item.itemId

		if (id == R.id.action_settings) {
			return true
		}

		return super.onOptionsItemSelected(item)
	}
}

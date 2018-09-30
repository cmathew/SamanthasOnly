package com.cmathew.samanthasonly

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import butterknife.BindView
import butterknife.ButterKnife.bind


class MainActivity : AppCompatActivity() {
	/*
	@BindView(R.id.matchBottomSheet)
	lateinit var matchBottomSheet: ConstraintLayout
	*/

	@BindView(R.id.toolbar)
	lateinit var toolbar: Toolbar

	lateinit var matchBottomSheet: ConstraintLayout

	// var sheetBehavior: BottomSheetBehavior<CoordinatorLayout>

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		bind(this)
		//matchBottomSheet = findViewById(R.id.matchBottomSheet)

		setupToolbar()

		/*
		private lateinit var mSectionsPagerAdapter: MemoryPagerAdapter
		mSectionsPagerAdapter = MemoryPagerAdapter(supportFragmentManager)
		container.adapter = mSectionsPagerAdapter
		*/
	}

	override fun onResume() {
		super.onResume()

//		var sheetBehavior = BottomSheetBehavior.from(matchBottomSheet)
//		sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		menuInflater.inflate(R.menu.menu_main, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		val id = item.itemId
		if (id == R.id.action_notifications) {
			// showNotificationFragment()
			return true
		}

		return super.onOptionsItemSelected(item)
	}

	private fun setupToolbar() {
		toolbar.title = "SamanthasOnly.com"
		setSupportActionBar(toolbar)
	}

	private fun showNotificationFragment() {
		val notifsFrag = NotificationsFragment.newInstance()
		val fragmentMgr: FragmentManager = supportFragmentManager
		fragmentMgr.beginTransaction().replace(R.id.mainContent, notifsFrag).commit()
	}
}

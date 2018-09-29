package com.cmathew.samanthasonly

import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import butterknife.BindView
import butterknife.ButterKnife


class MainActivity : AppCompatActivity() {
    /*
    @BindView(R.id.matchBottomSheet)
    lateinit var matchBottomSheet: ConstraintLayout
    */
    lateinit var matchBottomSheet: ConstraintLayout

    // var sheetBehavior: BottomSheetBehavior<CoordinatorLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ButterKnife.bind(this)
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
            val notifsFrag = NotificationsFragment()
            val fragmentMgr: FragmentManager = supportFragmentManager
            fragmentMgr.beginTransaction().replace(R.id.mainContent, notifsFrag).commit()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbarMain)
        toolbar.title = "beer and fear"
        setSupportActionBar(toolbar)
    }

/*
override fun onNavigationItemSelected(item: MenuItem): Boolean {
	if (item.isChecked) {
		return true
	}

	item.isChecked = true
	drawerLayout.closeDrawers()

	if (item.itemId == R.id.tree_navigation) {
		navigateToTreeFlipper()
		return true
	}

	return false
}

override fun onOptionsItemSelected(item: MenuItem): Boolean {
	// Pass the event to ActionBarDrawerToggle, if it returns
	// true, then it has handled the app icon touch event
	if (drawerToggle.onOptionsItemSelected(item)) {
		return true
	}

	val id = item.itemId
	if (id == R.id.action_notifications) {
		val notifsFrag = NotificationsFragment()
		val fragmentMgr: FragmentManager = supportFragmentManager
		fragmentMgr.beginTransaction().replace(R.id.mainContent, notifsFrag).commit()
		return true
	}

	return super.onOptionsItemSelected(item)
}

private fun setupToolbar() {
	val toolbar = findViewById<Toolbar>(R.id.toolbarMain)
	toolbar.title = "beer and fear"
	setSupportActionBar(toolbar)

	val actionBar = supportActionBar
	if (actionBar != null) {
		actionBar.setDisplayHomeAsUpEnabled(true)
		actionBar.setHomeButtonEnabled(true)
		setupDrawerNavigation()
	}
}


private fun setupDrawerNavigation() {
	navigationView.setNavigationItemSelectedListener(this)
	this.drawerToggle = object : ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open_content_desc, R.string.nav_close_content_desc) {
		override fun onDrawerOpened(drawerView: View?) {
			super.onDrawerOpened(drawerView)
		}

		override fun onDrawerClosed(drawerView: View?) {
			super.onDrawerClosed(drawerView)
		}
	}

	drawerLayout.addDrawerListener(drawerToggle)
	drawerToggle.setDrawerIndicatorEnabled(true)
}
*/
}

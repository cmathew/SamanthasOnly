package com.cmathew.samanthasonly

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife.bind

const val EXTRA_MATCH_ID = "EXTRA_MATCH_ID"

class MatchActivity : AppCompatActivity() {
	@BindView(R.id.toolbar)
	lateinit var toolbar: Toolbar

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_match)
		bind(this)

		setupToolbar()
	}

	private fun setupToolbar() {
		setSupportActionBar(toolbar)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
	}
}

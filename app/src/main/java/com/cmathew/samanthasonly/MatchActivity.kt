package com.cmathew.samanthasonly

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife.bind
import com.google.android.material.floatingactionbutton.FloatingActionButton

const val EXTRA_MATCH_ID = "EXTRA_MATCH_ID"

class MatchActivity : AppCompatActivity() {
	@BindView(R.id.toolbar)
	lateinit var toolbar: Toolbar
	@BindView(R.id.floating_action_button)
	lateinit var fab: FloatingActionButton

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_match)
		bind(this)

		setupToolbar()
		fab.setOnClickListener {
			val celebIntent = Intent(this, CelebrateActivity::class.java)
			startActivity(celebIntent)
		}
	}

	private fun setupToolbar() {
		setSupportActionBar(toolbar)
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
	}
}

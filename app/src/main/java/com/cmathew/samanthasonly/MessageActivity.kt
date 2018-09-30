package com.cmathew.samanthasonly

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NavUtils
import butterknife.BindView
import butterknife.ButterKnife.bind

const val EXTRA_MESSAGE_ID = "EXTRA_MESSAGE_ID"

class MessageActivity : AppCompatActivity() {
	@BindView(R.id.toolbar)
	lateinit var toolbar: Toolbar

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_message)
		bind(this)

		setupToolbar()
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			android.R.id.home -> {
				NavUtils.navigateUpFromSameTask(this)
				return true
			}
		}
		return super.onOptionsItemSelected(item)
	}

	private fun setupToolbar() {
		toolbar.title = "Message from Chris M."
		setSupportActionBar(toolbar)

		supportActionBar?.setDisplayHomeAsUpEnabled(true)
	}
}

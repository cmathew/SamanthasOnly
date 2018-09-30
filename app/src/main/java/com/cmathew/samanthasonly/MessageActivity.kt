package com.cmathew.samanthasonly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

const val EXTRA_MESSAGE_ID = "EXTRA_MESSAGE_ID"

class MessageActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_message)
	}
}

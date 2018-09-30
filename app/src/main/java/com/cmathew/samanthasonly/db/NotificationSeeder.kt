package com.cmathew.samanthasonly.db

import com.cmathew.samanthasonly.DatingApplication
import com.cmathew.samanthasonly.db.NotificationContract.NotificationType.*
import org.json.JSONObject
import javax.inject.Inject

class NotificationSeeder(application: DatingApplication) {
	@Inject
	lateinit var database: DatingDatabase

	init {
		application.applicationComponent!!.inject(this)
	}

	fun seed() {
		val welcomeNote = Notification(
				message = "Welcome to Samanthas Only.",
				type = WELCOME)

		val matchExtras = JSONObject("{ \"match_id\": 1}")
		val matchNote = Notification(
				message = "You have a new match.",
				type = NEW_MATCH,
				extras = matchExtras)

		val messageExtras = JSONObject("{ \"message_id\": 1}")
		val messageNote = Notification(
				message = "You have a new message!",
				type = NEW_MESSAGE,
				extras = messageExtras)

		listOf(messageNote, matchNote, welcomeNote).forEach { notification ->
			database.notificationDao().insert(notification)
		}
	}
}

package com.cmathew.samanthasonly.db

import com.cmathew.samanthasonly.DatingApplication
import javax.inject.Inject

class NotificationSeeder(application: DatingApplication) {
	@Inject
	lateinit var database: DatingDatabase

	init {
		application.applicationComponent!!.inject(this)
	}

	fun seed() {
		val notification1 = Notification(null, "You have a new match!", 0)
		val notification2 = Notification(null, "Welcome to Samanthas Only.", 0)

		listOf(notification1, notification2).forEach { notification ->
			database.notificationDao().insert(notification)
		}
	}
}

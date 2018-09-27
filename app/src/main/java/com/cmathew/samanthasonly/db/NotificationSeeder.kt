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
		database.notificationDao().insert(Notification(null, "hello world", 0))
	}
}

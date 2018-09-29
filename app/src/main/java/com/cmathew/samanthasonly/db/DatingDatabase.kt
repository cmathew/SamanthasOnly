package com.cmathew.samanthasonly.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
		entities = [Notification::class],
		version = DatingDatabase.VERSION,
		exportSchema = false)
abstract class DatingDatabase : RoomDatabase() {

	abstract fun notificationDao(): NotificationDao

	companion object {
		// DB Version
		const val VERSION = 1
	}
}

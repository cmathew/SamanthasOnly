package com.cmathew.samanthasonly.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

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

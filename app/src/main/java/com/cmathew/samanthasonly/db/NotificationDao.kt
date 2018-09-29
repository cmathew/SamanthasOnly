package com.cmathew.samanthasonly.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotificationDao {
	@Query("SELECT * FROM notification")
	fun getAll(): List<Notification>

	@Insert
	fun insert(note: Notification): Long
}
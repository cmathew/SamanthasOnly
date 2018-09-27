package com.cmathew.samanthasonly.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface NotificationDao {
	@Query("SELECT * FROM notification")
	fun getAll(): List<Notification>

	@Insert
	fun insert(note: Notification): Long
}
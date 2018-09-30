package com.cmathew.samanthasonly.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface NotificationDao {
	@Query("SELECT * FROM notification")
	fun getAll(): Flowable<List<Notification>>

	@Insert
	fun insert(note: Notification): Long
}
package com.cmathew.samanthasonly.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface NotificationDao {
	@Query("SELECT * FROM notification")
	fun getAll(): Flowable<List<Notification>>

	@Query("SELECT * FROM notification WHERE databaseId = :notificationId")
	fun getById(notificationId: Int): Single<Notification>

	@Insert
	fun insert(note: Notification): Long
}
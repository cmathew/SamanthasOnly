package com.cmathew.samanthasonly

import android.arch.persistence.room.*

@Entity(tableName = NotificationContract.TABLE_NAME)
data class Notification(
	@PrimaryKey(autoGenerate = true)
	var databaseId: Long?,

	@ColumnInfo(name = NotificationContract.NotificationEntry.COLUMN_MESSAGE)
	var message: String,

	@ColumnInfo(name = NotificationContract.NotificationEntry.COLUMN_IS_READ)
	var isMarkedRead: Int
)
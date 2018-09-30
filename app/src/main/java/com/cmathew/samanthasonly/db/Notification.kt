package com.cmathew.samanthasonly.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import org.json.JSONObject

@Entity(tableName = NotificationContract.TABLE_NAME)
@TypeConverters(JsonTypeConverter::class, NotificationTypeConverter::class)
data class Notification(
		@PrimaryKey(autoGenerate = true)
		var databaseId: Long? = null,

		@ColumnInfo(name = NotificationContract.NotificationEntry.COLUMN_MESSAGE)
		var message: String,

		@ColumnInfo(name = NotificationContract.NotificationEntry.COLUMN_TYPE)
		var type: NotificationContract.NotificationType,

		@ColumnInfo(name = NotificationContract.NotificationEntry.COLUMN_EXTRAS)
		var extras: JSONObject? = null,

		@ColumnInfo(name = NotificationContract.NotificationEntry.COLUMN_IS_READ)
		var isMarkedRead: Int = 0
)
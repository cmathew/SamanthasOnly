package com.cmathew.samanthasonly.db

import androidx.room.TypeConverter
import com.cmathew.samanthasonly.db.NotificationContract.NotificationType

class NotificationTypeConverter {
	@TypeConverter
	fun stringFromJson(data: NotificationType?): String? {
		return data?.name
	}

	@TypeConverter
	fun jsonFromString(data: String?): NotificationType? {
		return if (data == null) {
			null
		} else {
			NotificationType.valueOf(data)
		}
	}
}
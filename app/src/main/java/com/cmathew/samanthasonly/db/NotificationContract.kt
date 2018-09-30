package com.cmathew.samanthasonly.db

import android.provider.BaseColumns

object NotificationContract {
	const val TABLE_NAME = "notification"

	enum class NotificationType {
		NEW_MATCH,
		NEW_MESSAGE,
		WELCOME
	}

	class NotificationEntry : BaseColumns {
		companion object {
			const val COLUMN_MESSAGE = "message"
			const val COLUMN_TYPE = "type"
			const val COLUMN_EXTRAS = "extras"
			const val COLUMN_IS_READ = "is_read"
		}
	}
}

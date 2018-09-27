package com.cmathew.samanthasonly

import android.provider.BaseColumns

object NotificationContract {
	const val TABLE_NAME = "notification"

	class NotificationEntry : BaseColumns {
		companion object {
			const val COLUMN_MESSAGE = "message"
			const val COLUMN_IS_READ = "is_read"
		}
	}
}

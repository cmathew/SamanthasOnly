package com.cmathew.samanthasonly.db

import androidx.room.TypeConverter
import org.json.JSONObject


class JsonTypeConverter {
	@TypeConverter
	fun stringFromJson(data: JSONObject?): String? {
		return data?.toString()
	}

	@TypeConverter
	fun jsonFromString(data: String?): JSONObject? {
		return if (data == null) {
			null
		} else {
			JSONObject(data)
		}
	}
}
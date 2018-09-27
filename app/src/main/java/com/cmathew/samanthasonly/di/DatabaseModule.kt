package com.cmathew.samanthasonly.di

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.cmathew.samanthasonly.DatingApplication
import com.cmathew.samanthasonly.DatingDatabase
import com.cmathew.samanthasonly.NotificationSeeder
import com.cmathew.samanthasonly.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
	@Provides
	@Singleton
	fun provideDatabase(application: DatingApplication): DatingDatabase {
		val dbName = application.resources.getString(R.string.database_name)
		return Room.databaseBuilder(application, DatingDatabase::class.java, dbName)
				.allowMainThreadQueries()
				.addCallback(object : RoomDatabase.Callback() {
					override fun onCreate(db: SupportSQLiteDatabase) {
						super.onCreate(db)
						val noteSeeder = NotificationSeeder(application)
						noteSeeder.seed()
					}
				}).build()
	}


}
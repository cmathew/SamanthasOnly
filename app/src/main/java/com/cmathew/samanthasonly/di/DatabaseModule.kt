package com.cmathew.samanthasonly.di

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.cmathew.samanthasonly.DatingApplication
import com.cmathew.samanthasonly.R
import com.cmathew.samanthasonly.db.DatingDatabase
import com.cmathew.samanthasonly.db.NotificationSeeder
import dagger.Module
import dagger.Provides
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
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
						Completable.fromAction {
							val noteSeeder = NotificationSeeder(application)
							noteSeeder.seed()
						}.subscribeOn(Schedulers.io()).subscribe()
					}
				}).build()
	}


}
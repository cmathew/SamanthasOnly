package com.cmathew.samanthasonly.di

import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cmathew.samanthasonly.DatingApplication
import com.cmathew.samanthasonly.R
import com.cmathew.samanthasonly.db.DatingDatabase
import com.cmathew.samanthasonly.db.NotificationSeeder
import dagger.Module
import dagger.Provides
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton


@Module
class DatabaseModule {
	@Provides
	@Singleton
	fun provideDatabase(application: DatingApplication): DatingDatabase {
		val dbName = application.resources.getString(R.string.database_name)
		return Room.databaseBuilder(application, DatingDatabase::class.java, dbName)
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
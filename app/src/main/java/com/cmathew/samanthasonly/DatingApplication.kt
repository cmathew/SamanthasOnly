package com.cmathew.samanthasonly

import android.app.Application
import com.cmathew.samanthasonly.db.DatingDatabase
import com.cmathew.samanthasonly.di.ApplicationComponent
import com.cmathew.samanthasonly.di.DaggerApplicationComponent
import javax.inject.Inject

class DatingApplication : Application() {
	@Inject
	lateinit var database: DatingDatabase

	internal var applicationComponent: ApplicationComponent? = null

	override fun onCreate() {
		super.onCreate()

		applicationComponent = DaggerApplicationComponent.builder()
				.application(this)
				.build()
		applicationComponent!!.inject(this)
	}
}

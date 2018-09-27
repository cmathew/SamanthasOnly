package com.cmathew.samanthasonly

import android.app.Application
import com.cmathew.samanthasonly.di.ApplicationComponent
import com.cmathew.samanthasonly.di.DaggerApplicationComponent

class DatingApplication : Application() {

	internal var applicationComponent: ApplicationComponent? = null
		get() { return applicationComponent }

	override fun onCreate() {
		super.onCreate()

		this.applicationComponent = DaggerApplicationComponent.builder()
				.application(this)
				.build()
	}
}

package com.cmathew.samanthasonly.di

import com.cmathew.samanthasonly.DatingApplication
import com.cmathew.samanthasonly.db.NotificationSeeder
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class])
interface ApplicationComponent {
	@Component.Builder
	interface Builder {
		@BindsInstance
		fun application(application: DatingApplication): ApplicationComponent.Builder

		fun build(): ApplicationComponent
	}

	fun datingApplication(): DatingApplication

	fun inject(seeder: NotificationSeeder)
}

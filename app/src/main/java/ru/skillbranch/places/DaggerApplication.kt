package ru.skillbranch.places

import android.app.Activity
import android.app.Application
import ru.skillbranch.places.dagger2.ContextModule
import ru.skillbranch.places.dagger2.DaggerMainActivityComponent
import ru.skillbranch.places.dagger2.MainActivityComponent


class DaggerApplication : Application() {

    lateinit var daggerMainActivityComponent: MainActivityComponent

    companion object {
        fun get(activity: Activity): DaggerApplication {
            return activity.application as DaggerApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        daggerMainActivityComponent = DaggerMainActivityComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }


}
package ru.skillbranch.places

import android.app.Activity
import android.app.Application
import ru.skillbranch.places.dagger2.ContextModule
import ru.skillbranch.places.dagger2.DaggerDbComponent
import ru.skillbranch.places.dagger2.DbComponent


class DaggerApplication : Application() {

    lateinit var daggerDbComponent: DbComponent

    companion object {
        fun get(activity: Activity): DaggerApplication {
            return activity.application as DaggerApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        daggerDbComponent = DaggerDbComponent.builder()
            .contextModule(ContextModule(this))
            .build()
    }


}
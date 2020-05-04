package ru.skillbranch.places.dagger2

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.skillbranch.places.dataSource.RealmProvider

@Module(includes = [ContextModule::class])
class RealmProviderModule {

    @RealmProviderScope
    @Provides
    fun realmProvider(context: Context):RealmProvider =
        RealmProvider(context)
}
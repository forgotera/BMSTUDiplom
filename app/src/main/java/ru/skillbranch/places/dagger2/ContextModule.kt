package ru.skillbranch.places.dagger2

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(
    private val context: Context
) {

    @RealmProviderScope
    @Provides
    fun context():Context =
        context.applicationContext
}
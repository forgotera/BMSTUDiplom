package ru.skillbranch.places.dagger2

import dagger.Component
import ru.skillbranch.places.dataSource.RealmProvider

@RealmProviderScope
@Component(modules = [RealmProviderModule::class])
interface DbComponent {

    fun getRealmProvider(): RealmProvider
}

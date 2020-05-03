package ru.skillbranch.places.dataSource

import io.realm.Realm
import io.realm.RealmModel

fun <R : RealmModel> Realm.maybeCopyFrom(block: (Realm) -> R?): R? =
    use { realm -> block(realm)?.let(::copyFromRealm) }

fun <R : RealmModel> Realm.maybeCopyListFrom(block: (Realm) -> List<R>?): List<R> =
    use { realm ->
        block(realm)?.let { copyFromRealm(it) } ?: emptyList()
    }

fun Realm.useExecuteTransaction(block: (Realm) -> Unit) {
    use { it.executeTransaction(block) }
}
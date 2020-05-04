package ru.skillbranch.places.dataSource

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmException
import javax.inject.Inject

class RealmProvider @Inject constructor(
    private val context: Context
) {
    private var configuration: RealmConfiguration? = null

    private val _realm: Realm?
        get() = try {
            configuration?.let { Realm.getInstance(it) }
        } catch (e: RealmException) {
            null
        }

    var onRealmInitializing: (() -> Unit)? = null

    var onRealmClosing: (() -> Unit)? = null

    val instance: Realm
        get() = _realm ?: error("Realm not initialized")

    fun initialization(): Boolean {
        val pinConfiguration = realmConfiguration()
        return when {
            checkRealm(pinConfiguration) -> {
                this.configuration = pinConfiguration
                if (isInitialized()) {
                    onRealmInitializing?.invoke()
                    true
                } else {
                    false
                }
            }
            else -> false
        }
    }

    fun isInitialized(): Boolean = _realm.use { it != null }

    fun close() {
        if (isInitialized()) {
            _realm?.executeTransaction { realm -> realm.deleteAll() }
            onRealmClosing?.invoke()
        }
        configuration = null
        Realm.deleteRealm(realmConfiguration())
    }

    private fun realmConfiguration(): RealmConfiguration {
        Realm.init(context)


        return RealmConfiguration.Builder()
            .name("rb.realm")
            .build()
    }

    private fun checkRealm(config: RealmConfiguration): Boolean = try {
        Realm.getInstance(config).use { it != null }
    } catch (e: Exception) {
        false
    }
}
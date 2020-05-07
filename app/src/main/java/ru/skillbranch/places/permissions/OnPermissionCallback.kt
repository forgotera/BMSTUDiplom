package ru.skillbranch.places.permissions

import android.app.Activity
import android.content.pm.PackageManager
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat

interface OnPermissionCallback {
    fun checkSelfPermission(@NonNull permission: String): Boolean
    fun shouldShowRequestPermissionRationale(permission: String): Boolean
    fun requestPermissions(@NonNull permissions: Array<String>, requestCode: Int)
}

class InnerPermissionCallback(
    private val activity: Activity
) : OnPermissionCallback {

    override fun checkSelfPermission(permission: String): Boolean =
        ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED

    override fun shouldShowRequestPermissionRationale(permission: String): Boolean =
        ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)

    override fun requestPermissions(permissions: Array<String>, requestCode: Int) =
        ActivityCompat.requestPermissions(activity, permissions, requestCode)
}
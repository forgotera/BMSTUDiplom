package ru.skillbranch.places.permissions

import android.content.pm.PackageManager

private val REQUEST_CODE = 9
private val RATIONALE_REQUEST_CODE = 10

typealias PermissionDenied = (List<String>) -> Unit
typealias PermissionGranted = () -> Unit

class PermissionModule(
    private val onPermissionCallback: OnPermissionCallback,
    private val reqCode: Int = REQUEST_CODE,
    private val rationaleReqCode: Int = RATIONALE_REQUEST_CODE
) {

    private var _denied: PermissionDenied? = null
    private var _granted: PermissionGranted? = null

    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        when (requestCode) {
            reqCode,
            rationaleReqCode -> {

                val denied = mutableListOf<String>()
                grantResults.forEachIndexed { index, value ->
                    when (value) {
                        PackageManager.PERMISSION_DENIED -> denied.add(permissions[index])
                    }
                }

                when {
                    denied.isEmpty() -> _granted?.invoke()
                    else             -> _denied?.invoke(denied.toList())
                }
            }
        }
    }

    fun checkPermission(permission: String, granted: PermissionGranted, denied: PermissionDenied? = null) =
        checkPermissions(arrayOf(permission), granted, denied)

    fun checkPermissions(permissions: Array<String>, granted: PermissionGranted, denied: PermissionDenied? = null) {

        _denied = denied
        _granted = granted

        val notGranted = permissions
            .filter { !onPermissionCallback.checkSelfPermission(it) }
            .toTypedArray()

        val rationale = notGranted.any { permission ->
            onPermissionCallback.shouldShowRequestPermissionRationale(permission)
        }

        when {
            notGranted.isEmpty() -> granted.invoke()
            rationale            -> onPermissionCallback.requestPermissions(permissions, rationaleReqCode)
            else                 -> onPermissionCallback.requestPermissions(permissions, reqCode)
        }
    }
}
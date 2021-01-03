package com.artik.core

import android.Manifest
import android.content.Context
import com.androidisland.ezpermission.EzPermission

class PermissionManager(
    private val context: Context
) {
    fun askStoragePermissionIfNeed(
        onGranted: () -> Unit,
        onDenied: () -> Unit,
        onDeniedPermanently: () -> Unit
    ) {
        EzPermission.with(context)
            .permissions(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            .request { granted, denied, permanentlyDenied ->

                if (granted.isNotEmpty()) {
                    onGranted.invoke()
                }

                if (denied.isNotEmpty()) {
                    onDenied.invoke()
                }

                if (permanentlyDenied.isNotEmpty()) {
                    onDeniedPermanently.invoke()
                }
            }
    }
}
package com.cst.academy2024unibucfmi.utils.extensions

import android.util.Log

fun String.logErrorMessage(tag: String = "AppTag") {
    Log.e(tag, this)
}
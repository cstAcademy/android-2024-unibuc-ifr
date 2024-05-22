package com.cst.academy2024unibucfmi.managers

import android.content.Context
import com.cst.academy2024unibucfmi.ApplicationController

object SharedPrefsManager {

    const val FILE_NAME = "academy2024unibucfmi"

    const val ARG_TOKEN = "ARG_TOKEN"

    private val sharedPreferences =
        ApplicationController.instance.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)

    fun writeToken(token: String) = write(ARG_TOKEN, token)

    private fun write(key: String, value: String) {
        with (sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    private fun write(key: String, value: Int) {
        with (sharedPreferences.edit()) {
            putInt(key, value)
            apply()
        }
    }

    fun readToken() = readString(ARG_TOKEN)

    private fun readString(key: String) = sharedPreferences.getString(key, null)

    fun removeToken() = remove(ARG_TOKEN)

    private fun remove(key: String) {
        with (sharedPreferences.edit()) {
            remove(key)
            apply()
        }
    }
}
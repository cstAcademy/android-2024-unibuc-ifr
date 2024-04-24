package com.cst.academy2024unibucfmi

import android.app.Application

class ApplicationController: Application() {

    companion object {
        lateinit var instance: ApplicationController
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

}
package com.cst.academy2024unibucfmi

import android.app.Application
import androidx.room.Room
import com.cst.academy2024unibucfmi.data.AppDatabase

class ApplicationController : Application() {

    lateinit var appDatabase: AppDatabase
        private set

    companion object {
        lateinit var instance: ApplicationController
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        setupDatabase()
    }

    private fun setupDatabase() {
        appDatabase = Room.databaseBuilder(
            this, AppDatabase::class.java, "CST_FMI"
        )
            .fallbackToDestructiveMigration() // DEVELOPMENT ONLY
            .build()
    }

}
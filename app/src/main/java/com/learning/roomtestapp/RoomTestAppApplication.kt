package com.learning.roomtestapp

import android.app.Application
import androidx.room.Room
import com.learning.roomtestapp.db.ContactDatabase
import com.learning.roomtestapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class RoomTestAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@RoomTestAppApplication)
            modules(dataModule)
            modules(presentationModule)
        }
    }

    private val dataModule = module {
        single {
            Room.databaseBuilder(
                applicationContext,
                ContactDatabase::class.java,
                "contact.db"
            ).build()
        }

        single {
           get<ContactDatabase>().dao
        }
    }
}
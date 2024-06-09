package app

import android.app.Application
import main.di.AppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
    }
}
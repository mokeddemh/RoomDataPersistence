package example.android.com.roomdatapersistence

import android.app.Application
import example.android.com.roomdatapersistence.roomdatabase.RoomService

class App:Application(){
    override fun onCreate() {
        super.onCreate()
        RoomService.context = applicationContext
    }
}
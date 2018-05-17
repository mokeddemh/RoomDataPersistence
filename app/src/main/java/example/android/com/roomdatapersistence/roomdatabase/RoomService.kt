package example.android.com.roomdatapersistence.roomdatabase

import android.arch.persistence.room.Room
import android.content.Context

object RoomService {

    lateinit var context:Context

    val appDataBase: AppDataBase by lazy {
        Room.databaseBuilder(context,AppDataBase::class.java,"dbteams").allowMainThreadQueries().build()
    }



}
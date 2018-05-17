package example.android.com.roomdatapersistence.roomdatabase

import android.arch.persistence.room.Room
import android.content.Context

object RoomService {

    lateinit var context:Context
    val sqliteDataBase:SQLiteDataBase by lazy {
        Room.databaseBuilder(context,SQLiteDataBase::class.java,"db_teams")
                .allowMainThreadQueries().build() }
}
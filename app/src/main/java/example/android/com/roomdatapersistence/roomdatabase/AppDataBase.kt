package example.android.com.roomdatapersistence.roomdatabase

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import example.android.com.roomdatapersistence.entity.Player
import example.android.com.roomdatapersistence.entity.Team
import example.android.com.roomdatapersistence.roomdao.PlayerDao
import example.android.com.roomdatapersistence.roomdao.TeamDao

@Database(entities = arrayOf(Team::class,Player::class),version = 1)
abstract class AppDataBase:RoomDatabase() {

    abstract fun getTeamDao():TeamDao
    abstract fun getPlayerDao():PlayerDao
}
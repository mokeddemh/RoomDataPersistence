package example.android.com.roomdatapersistence.roomdao

import android.arch.persistence.room.*
import example.android.com.roomdatapersistence.entity.Player
import example.android.com.roomdatapersistence.entity.Team

@Dao
interface PlayerDao {

    @Query("select * from players")
    fun getPlayers():List<Player>

    @Query("select * from players where first_name=:firstName and last_name=:lastName")
    fun getPlayerByName(firstName:String,lastName:String): Player


    @Insert
    fun addPlayer(vararg player: Player)

    @Update
    fun updatePlayer(player: Player)

    @Delete
    fun deletePlayer(player: Player)

    @Delete
    fun deleteAllPlayers(players:List<Player>)

}
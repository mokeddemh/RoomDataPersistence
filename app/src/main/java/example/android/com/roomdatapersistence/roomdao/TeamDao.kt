package example.android.com.roomdatapersistence.roomdao

import android.arch.persistence.room.*
import example.android.com.roomdatapersistence.entity.Team

@Dao
interface TeamDao {

    @Query("select * from teams")
    fun getTeams():List<Team>

    @Query("select * from teams where team_name=:teamName")
    fun getTeamByName(teamName:String):Team


    @Insert
    fun addTeam(vararg team: Team)

    @Update
    fun updateTeam(team: Team)

    @Delete
    fun deleteTeam(team: Team)

    @Delete
    fun deleteAllTeams(teams:List<Team>)

}



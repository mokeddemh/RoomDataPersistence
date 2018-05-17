package example.android.com.roomdatapersistence.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "players"
       , foreignKeys = arrayOf(ForeignKey(entity = Team::class,
        parentColumns = arrayOf("team_id"),
        childColumns = arrayOf("team_id"),
        onDelete = ForeignKey.CASCADE))
)
data class Player(
        @ColumnInfo(name = "first_name")
        var firstName:String,
        @ColumnInfo(name = "last_name")
        var lastName:String,
        var age:Int,
        var height:Double,
        @ColumnInfo(name = "team_id")
        var teamId:Long
) {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "player_id")
        var playerId:Int?=null
}
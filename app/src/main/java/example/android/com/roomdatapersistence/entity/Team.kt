package example.android.com.roomdatapersistence.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "teams")
data class Team(
        @ColumnInfo(name = "team_name")
        var teamName:String,
        var continent:String
) {
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "team_id")
        var teamId:Int?=null
}
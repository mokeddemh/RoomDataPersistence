package com.example.petuserexample.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    var userId:Int?= null,
    @ColumnInfo(name = "first_name")
    val fName:String,
    @ColumnInfo(name = "last_name")
    val lName:String

)

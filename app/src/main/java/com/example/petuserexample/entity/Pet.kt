package com.example.petuserexample.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "pets",foreignKeys = [
    ForeignKey(entity = User::class,parentColumns = ["userId"],childColumns = ["owner"],
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )])

data class Pet (
    @PrimaryKey(autoGenerate = true)
    var petId:Int?=null,
    val name:String,
    val owner:Int
    )
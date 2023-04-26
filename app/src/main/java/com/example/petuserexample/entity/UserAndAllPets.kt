package com.example.petuserexample.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndAllPets (
    @Embedded
    val user:User?,
    @Relation(parentColumn = "userId",entityColumn = "owner")
    val pets:List<Pet>


)
package com.example.petuserexample.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.petuserexample.entity.Pet

@Dao
interface PetDao:BaseDao<Pet> {

    @Query("SELECT * FROM PETS")
    fun getAllPets():List<Pet>

}
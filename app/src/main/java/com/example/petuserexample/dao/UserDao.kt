package com.example.petuserexample.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.petuserexample.entity.User
import com.example.petuserexample.entity.UserAndAllPets


@Dao
interface UserDao:BaseDao<User> {

    @Query("SELECT * FROM USERS")
    fun getAllUsers():List<User>

    @Query("SELECT * FROM USERS")
    fun getUserPets():List<UserAndAllPets>

}
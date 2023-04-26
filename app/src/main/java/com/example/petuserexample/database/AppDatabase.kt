package com.example.petuserexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.petuserexample.dao.PetDao
import com.example.petuserexample.dao.UserDao
import com.example.petuserexample.entity.Pet
import com.example.petuserexample.entity.User

@Database(entities = [User::class,Pet::class],version=1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun getUserDo(): UserDao
    abstract fun getPetDo():PetDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun buildDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
               synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context,AppDatabase::class.java, "pets_db").allowMainThreadQueries().build()
               }
            }
            return INSTANCE
        }
    }

}
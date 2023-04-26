package com.example.petuserexample

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.petuserexample.database.AppDatabase
import com.example.petuserexample.entity.Pet
import com.example.petuserexample.entity.User
import com.example.petuserexample.entity.UserAndAllPets
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    lateinit var mDataBase: AppDatabase


    @Before
    fun initDB() {
        mDataBase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.
        getInstrumentation().context,AppDatabase::class.java).build()
    }

    @Test
    fun testAddGetUser() {
      val user = User(fName = "test", lName = "test")
      mDataBase.getUserDo().insert(user)
      val user1 = mDataBase.getUserDo().getAllUsers().get(0)
      val expectedUser = User(1,"test",  "test")
        assertEquals(expectedUser,user1)
    }

    @Test
    fun testAddGetPets() {
        val user = User(fName = "test", lName = "test")
        val pet = Pet(name = "dog", owner = 1)
        mDataBase.getUserDo().insert(user)
        mDataBase.getPetDo().insert(pet)
        val pet1 = mDataBase.getPetDo().getAllPets().get(0)
        val expectedPet = Pet(1,"dog",  1)
        assertEquals(expectedPet,pet1)
    }


    @Test
    fun testAddGetUserPets() {
        val expectedList = mutableListOf<UserAndAllPets>()
        val user1 = User(fName = "test1", lName = "test1")
        val user2 = User(fName = "test2", lName = "test2")
        val pet1 = Pet(name = "dog1", owner = 1)
        val pet2 = Pet(name = "dog2", owner = 1)
        val pet3 = Pet(name = "dog3", owner = 2)
        val pet4 = Pet(name = "dog4", owner = 2)
        val pet5 = Pet(name = "dog5", owner = 2)

        mDataBase.getUserDo().insert(user1,user2)
        mDataBase.getPetDo().insert(pet1,pet2,pet3,pet4,pet5)
        // Set IDs for Users and Pets
        user1.userId = 1
        user2.userId = 2
        pet1.petId = 1
        pet2.petId = 2
        pet3.petId = 3
        pet4.petId = 4
        pet5.petId = 5
        // Expected lists
        expectedList.add(UserAndAllPets(user1, mutableListOf(pet1,pet2)))
        expectedList.add(UserAndAllPets(user2, mutableListOf(pet3,pet4,pet5)))
        // getInsertedUserPets
        val userPets = mDataBase.getUserDo().getUserPets()
        // Assertion
        assertArrayEquals(expectedList.toTypedArray(),userPets.toTypedArray())

    }

    @After
    fun closeDb(){
        mDataBase?.close()
    }
}
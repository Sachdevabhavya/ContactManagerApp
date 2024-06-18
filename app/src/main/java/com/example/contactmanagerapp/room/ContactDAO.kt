package com.example.contactmanagerapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

//DAO:Data Access Object , defines the methods to interact with DB
@Dao
interface ContactDAO {
//insert is a coroutine function
//coroutines are used for asynchronous programming in kotlin , these are often used to perform DB operations
//suspend function is used to perform insertcontact function in the background and not block the ui thread, used for creating coroutines

    @Insert
    suspend fun insertContact(contact: Contact):Long

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    //query is used to pass queries (sql queries)
    @Query("DELETE FROM contacts_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM contacts_table")
    fun getAllContactsInDB(): LiveData<List<Contact>>
}
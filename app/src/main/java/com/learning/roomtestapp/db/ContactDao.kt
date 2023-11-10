package com.learning.roomtestapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

import kotlinx.coroutines.flow.Flow


@Dao
interface ContactDao {

    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact ORDER by firstName ASC")
    fun getContactOrderedByFirstName() : Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER by lastName ASC")
    fun getContactOrderedByLastName() : Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER by phoneNumber ASC")
    fun getContactOrderedByPhoneNumber() : Flow<List<Contact>>

}
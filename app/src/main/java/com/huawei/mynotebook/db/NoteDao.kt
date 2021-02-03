package com.huawei.mynotebook.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    suspend fun addNote(note: Note)//suspend means we need to call this function on coroutines scope

    @Query("SELECT * FROM note")//note bizim table name oluyor bunu yanlış yazınca hata verir
    suspend fun getAllNotes(): List<Note>     //it will return all notes from database

    @Insert
    suspend fun addMultipleNotes(vararg note: Note)


}
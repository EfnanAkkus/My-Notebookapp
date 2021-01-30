package com.huawei.mynotebook.db

import androidx.room.Insert
import androidx.room.Query

interface NoteDao {
    @Insert
    fun addNote(note: Note)

    @Query("SELECT * FROM note")//note bizim table name oluyor bunu yanlış yazınca hata verir
    fun getAllNotes():List<Note>     //it will return all notes from database

    @Insert
    fun addMultipleNotes(vararg note: Note)


}
package com.huawei.mynotebook.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext


@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    //database'i built etmek için companion object yazıyoruz
    companion object {
        //volatile değerleri var olarak tanımlarız val olmaz volatile means this
        // instance is emmadialtly avaible for all the other threats
        @Volatile
        private var instance: NoteDatabase? = null
        private val LOCK = Any()

        //this invoke will check if instance is not null, we will return instance but if instance is null we will
        //write syncronize(we use LOCK object for syncronized class)
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            //if instance is null I will call a function
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        //this function will return us the database
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            // databaseBuilder takes 3 parametre
            //if we will past the context from fragment it wil take the applicationContext
            context.applicationContext,
            NoteDatabase::class.java,
            "notedatabase"
        ).build()

    }
}
package com.huawei.mynotebook.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(//Note Entity yani burda bizim veritabanı tablomuz oluyor BU tablo için 3 tane coloum var

    val title: String,
    val note: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int=0
}
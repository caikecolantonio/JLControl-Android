package com.example.jlima


import androidx.room.Database
import androidx.room.RoomDatabase


// anotação define a lista de entidades e a versão do banco
@Database(entities = arrayOf(ListaTerno::class), version = 1)
abstract class ListaTernoDatabase: RoomDatabase() {
    abstract fun listaTernoDAO(): ListaTernoDAO
}
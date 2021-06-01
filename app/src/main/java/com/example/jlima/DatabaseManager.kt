package com.example.jlima

import androidx.room.Room


object DatabaseManager {

    // singleton
    private var dbInstance: ListaTernoDatabase
    init {
        val appContext = JLimaApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext, // contexto global
            ListaTernoDatabase::class.java, // Referência da classe do banco
            "lms.sqlite" // nome do arquivo do banco
        ).build()
    }

    fun getListaTernoDao(): ListaTernoDAO {
        return dbInstance.listaTernoDAO()
    }
}
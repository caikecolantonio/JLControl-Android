package com.example.jlima

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ListaTernoDAO {
    @Query("SELECT * FROM ListaTerno where codigo = :codigo")
    fun getById(codigo: String) : ListaTerno?

    @Query("SELECT * FROM ListaTerno")
    fun findAll(): List<ListaTerno>

    @Insert
    fun insert(listaTerno: ListaTerno)

    @Delete
    fun delete(listaTerno: ListaTerno)

}

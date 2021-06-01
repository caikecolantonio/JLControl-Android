package com.example.jlima

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "ListaTerno")
class ListaTerno : Serializable {
    var ativo = ""
    @PrimaryKey
    var codigo = ""
    var corte = ""
    var id = 0
    var modelo = ""
    var nome = ""
    var valor = ""
    var foto = ""



    override fun toString(): String {
        return "Terno(nome='$nome')"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}




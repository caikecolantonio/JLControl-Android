package com.example.jlima

import android.content.Context
import com.google.gson.GsonBuilder
import java.io.Serializable

class ListaTerno : Serializable {
    var ativo = ""
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




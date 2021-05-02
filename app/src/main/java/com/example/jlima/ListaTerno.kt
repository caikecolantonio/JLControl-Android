package com.example.jlima

import android.content.Context
import java.io.Serializable

class ListaTerno : Serializable {
    var id:Long = 0
    var nome = ""
    var codigo = ""
    var foto = ""

    override fun toString(): String {
        return "Terno(nome='$nome')"
    }
}




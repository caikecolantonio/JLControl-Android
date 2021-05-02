package com.example.jlima

import android.content.Context

object TernoService {
    fun getDisciplinas (context: Context): List<ListaTerno> {
        val ternos = mutableListOf<ListaTerno>()
// criar 10 disciplinas
        for (i in 1..10) {
            val d = ListaTerno()
            d.nome = "Terno $i"
            d.codigo = "Codigo Terno $i"
            d.foto = "https://i.pinimg.com/564x/d0/8c/16/d08c16b78377d5c102dbf19464d83ba1.jpg"
            ternos.add(d)
        }
        return ternos
    }

}
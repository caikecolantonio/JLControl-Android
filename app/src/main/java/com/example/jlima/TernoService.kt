package com.example.jlima

import android.content.Context
import kotlin.random.Random

object TernoService {
    val lista_img = mutableListOf<String>("https://grottoferreira.com.br/wp-content/uploads/2020/07/terno-GF333500481-f3.jpg",
                                        "https://img.elo7.com.br/product/zoom/2DD2C8F/terno-slim-preto-oxford-original-lavancco-loja-da-fabrica-casual-esporte-fino.jpg",
                                        "https://i0.wp.com/www.canalmasculino.com.br/wp-content/uploads/2018/04/destaque-video-comprar-primeiro-terno.jpg?resize=570%2C568",
                                        "https://carmimmodas.vteximg.com.br/arquivos/ids/161135-1000-1500/terno.jpg?v=636886886410570000")
    val lista_nome = mutableListOf<String>("Terno Australiano", "Terno Tradicional", "Terno Slim", "Terno Super Slim")
    fun getTernos (context: Context): List<ListaTerno> {
        val ternos = mutableListOf<ListaTerno>()
// criar 10 disciplinas
        for (i in 1..10) {
            val rand = Random.nextInt(0,lista_img.size)
            val d = ListaTerno()
            d.nome = lista_nome[rand]
            d.codigo = "Codigo Terno $i"
            d.foto = lista_img[rand]
            ternos.add(d)
        }
        return ternos
    }

}
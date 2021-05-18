package com.example.jlima

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Response
import java.net.URL

import kotlin.random.Random

object TernoService {
    val host = "http://10.0.2.2:8000"
    fun getTernos (context: Context): List<ListaTerno> {
        val url = "$host/trajes/"

        val json = HttpHelper.get(url)
        return parserJson<List<ListaTerno>>(json)

    }
    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
    fun save(ListaTerno: ListaTerno): Response {
        val json = HttpHelper.post("$host/trajes/", ListaTerno.toJson())
        return parserJson(json)
    }
    fun delete(ListaTerno: ListaTerno): Response {
        val url = "$host/trajes/"
        val json = HttpHelper.delete(url, ListaTerno.codigo)
        return parserJson<Response>(json)
    }
}
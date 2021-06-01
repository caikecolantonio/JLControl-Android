package com.example.jlima

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Response

object TernoService {
    val host = "https://jlima-control.herokuapp.com"
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun getTernos (context: Context): List<ListaTerno> {
        val url = "$host/trajes/"
        var tabela_ternos = ArrayList<ListaTerno>()
        if (AndroidUtils.isInternetDisponivel(context)) {
            val json = HttpHelper.get(url)
            tabela_ternos = parserJson(json)
                for (d in tabela_ternos){
                    saveOffline(d)
                }
                return tabela_ternos
            } else {
            val dao = DatabaseManager.getListaTernoDao()
            val tabela_ternos = dao.findAll()
            return tabela_ternos
        }
    }
    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun save(ListaTerno: ListaTerno, context: Context): com.example.jlima.Response {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val json = HttpHelper.post("$host/trajes/", ListaTerno.toJson())
            return parserJson(json)
        } else{
            saveOffline(ListaTerno)
            return Response(status = "OK", msg = "Dados salvos localmente" )
    }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun delete(ListaTerno: ListaTerno, context: Context): com.example.jlima.Response {

        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/trajes/"
            val json = HttpHelper.delete(url, ListaTerno.codigo)

            return parserJson(json)
        } else {
            val dao = DatabaseManager.getListaTernoDao()
            dao.delete(ListaTerno)
            return Response(status = "OK", msg = "Dados salvos localmente")
        }
    }

    fun saveOffline(lista_terno: ListaTerno) : Boolean {
        val dao = DatabaseManager.getListaTernoDao()

        if (! existeTerno(lista_terno)) {
            lista_terno.foto = "offline"
            dao.insert(lista_terno)
        }
        return true
    }
    fun existeTerno(lista_terno: ListaTerno): Boolean {
        val dao = DatabaseManager.getListaTernoDao()
        return dao.getById(lista_terno.codigo) != null
    }

}
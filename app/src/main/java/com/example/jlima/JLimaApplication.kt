/*
Baseado nos códigos do livro
LECHETA, R. R. Android Essencial com Kotlin. Edição: 1ª ed. Novatec, 2017. 

Código original: https://github.com/livroandroid/kotlin-essencial-1ed
*/

package com.example.jlima

import android.app.Application
import java.lang.IllegalStateException

class JLimaApplication: Application() {
    // chamado quando android iniciar o processo da aplicação
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        // singleton
        private var appInstance: JLimaApplication?  = null
        fun getInstance(): JLimaApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configurar application no Android Manifest")
            }
            return appInstance!!
        }
    }

    // chamado quando android terminar processo da aplicação
    override fun onTerminate() {
        super.onTerminate()
    }
}
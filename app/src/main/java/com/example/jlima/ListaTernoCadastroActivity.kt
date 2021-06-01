package com.example.jlima

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_lista_terno_cadastro.*

class ListaTernoCadastroActivity : AppCompatActivity() {
    private val context: Context get() = this

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_terno_cadastro)
        setTitle("Novo Terno")

        salvarTerno.setOnClickListener {
            val terno = ListaTerno()
            terno.codigo = codigoTerno.text.toString()
            terno.nome = nomeTerno.text.toString()
            terno.modelo = modeloTerno.text.toString()
            terno.corte = corteTerno.text.toString()
            terno.valor = valorTerno.text.toString()

            taskAtualizar(terno)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun taskAtualizar(Terno: ListaTerno) {
        // Thread para salvar a discilpina
        Thread {
            TernoService.save(Terno, context)
            runOnUiThread {
                // após cadastrar, voltar para activity anterior
                startActivity(Intent(this@ListaTernoCadastroActivity, ConsultarActivity::class.java))
            }
        }.start()
    }
}
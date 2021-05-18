package com.example.jlima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_terno.*
import kotlinx.android.synthetic.main.menu_lateral_cabecalho.*

class TernoActivity : AppCompatActivity() {
    var listaTerno: ListaTerno? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terno)
// recuperar onjeto de Disciplina da Intent
        listaTerno = intent.getSerializableExtra("ternos") as ListaTerno
// configurar título com nome da Disciplina e botão de voltar da Toolbar
// alterar título da ActionBar
        supportActionBar?.title = listaTerno?.nome
// up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        cardNome.text = listaTerno?.nome
        Picasso.with(this).load(listaTerno?.foto).fit().into(imagemuser,

            object: com.squareup.picasso.Callback{
                override fun onSuccess() {}
                override fun onError() { }
            })
    }


}
package com.example.jlima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.botaologin);
        button.setOnClickListener {
            //if (findViewById<EditText>(R.id.txtLogin).text.toString() == "aluno" && findViewById<EditText>(R.id.txtSenha).text.toString() == "impacta"){

            startActivity(Intent(this@MainActivity, InicialActivity::class.java))
            //}else{
              //  findViewById<TextView>(R.id.textView).text = "Usuário ou senha incorretos"
           // }
        }

    }
}




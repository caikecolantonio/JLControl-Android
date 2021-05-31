package com.example.jlima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_consultar.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.botaologin);
        button.setOnClickListener {
            taskTernos()
        }
        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            var lembrarNome = Prefs.getString("lembrarNome")
            var lembrarSenha = Prefs.getString("lembrarSenha")
            findViewById<EditText>(R.id.txtLogin).setText(lembrarNome)
            findViewById<EditText>(R.id.txtSenha).setText(lembrarSenha)
            findViewById<CheckBox>(R.id.checkLembrar).isChecked = lembrar
        }

    }
    fun taskTernos() {
        Thread {
            val valorUsuario = findViewById<EditText>(R.id.txtLogin).text.toString()
            val valorSenha = findViewById<EditText>(R.id.txtSenha).text.toString()
            var reqParam = URLEncoder.encode("login", "UTF-8") + "=" + URLEncoder.encode(valorUsuario, "UTF-8")
            reqParam += "&" + URLEncoder.encode("senha", "UTF-8") + "=" + URLEncoder.encode(valorSenha, "UTF-8")
            val mURL = URL("https://jlima-control.herokuapp.com/login-mobile/")


            // armazenar valor do checkbox
            Prefs.setBoolean("lembrar", findViewById<CheckBox>(R.id.checkLembrar).isChecked)
            // verificar se é para lembrar nome e senha
            if (findViewById<CheckBox>(R.id.checkLembrar).isChecked) {
                Prefs.setString("lembrarNome", valorUsuario)
                Prefs.setString("lembrarSenha", valorSenha)
            } else{
                Prefs.setString("lembrarNome", "")
                Prefs.setString("lembrarSenha", "")
            }

            with(mURL.openConnection() as HttpURLConnection) {
                // optional default is GET
                requestMethod = "POST"
                setRequestProperty("Content-Type", "application/json")


                val wr = OutputStreamWriter(getOutputStream());
                wr.write(reqParam);
                wr.flush();

                println("URL : $url")
                println("Response Code : $responseCode")

                runOnUiThread {
                    BufferedReader(InputStreamReader(inputStream)).use {
                        val response = StringBuffer()

                        var inputLine = it.readLine()
                        while (inputLine != null) {
                            response.append(inputLine)
                            inputLine = it.readLine()
                        }
                        if (response.toString().toInt() == 1) {
                            startActivity(Intent(this@MainActivity, InicialActivity::class.java))
                        } else {
                            findViewById<TextView>(R.id.textView).text =
                                "Usuário ou senha incorretos"
                        }
                    }
                }
            }
        }.start()
    }

}

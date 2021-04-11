package com.example.jlima

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class InicialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)

        // Get the support action bar
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        // Set the action bar title, subtitle and elevation
        actionBar!!.title = "JLima"
        actionBar.elevation = 4.0F

        //BUTTON MUDAR TEXTO MEDIDAS
        val button = findViewById<Button>(R.id.button_medidas);
        val intent_medidas = Intent(this@InicialActivity, AcaoActivity::class.java)
        intent_medidas.putExtra("titulo", "Medidas")
        button.setOnClickListener {
            startActivity(intent_medidas)
        }
        //BUTTON MUDAR TEXTO DEVOLVER
        val buttonDevolver = findViewById<Button>(R.id.button_devolver);
        val intent_devolver = Intent(this@InicialActivity, AcaoActivity::class.java)
        intent_devolver.putExtra("titulo", "Devolver")
        buttonDevolver.setOnClickListener {
            startActivity(intent_devolver)
        }
        //BUTTON MUDAR TEXTO ENCONTRAR
        val buttonEncontrar = findViewById<Button>(R.id.button_encontrar);
        val intent_encontrar = Intent(this@InicialActivity, AcaoActivity::class.java)
        intent_encontrar.putExtra("titulo", "Encontrar")
        buttonEncontrar.setOnClickListener {
            startActivity(intent_encontrar)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // Handle presses on the action bar menu items
    when (item.itemId) {
        R.id.action_locar -> {
            startActivity(Intent(this@InicialActivity, LocarActivity::class.java))
            return true
        }
        R.id.action_consultar -> {
            startActivity(Intent(this@InicialActivity, LocarActivity::class.java))
            return true
        }
        R.id.action_sair -> {
            startActivity(Intent(this@InicialActivity, MainActivity::class.java))
            return true
        }

    }
    return super.onOptionsItemSelected(item)
}
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}

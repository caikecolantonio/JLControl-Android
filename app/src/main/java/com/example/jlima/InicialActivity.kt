package com.example.jlima

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class InicialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)

        // Get the support action bar
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        // Set the action bar title, subtitle and elevation
        actionBar!!.title = "Kotlin"
        actionBar.subtitle = "Many useful kotlin examples."
        actionBar.elevation = 4.0F
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
            startActivity(Intent(this@InicialActivity, MainActivity::class.java))
            return true
        }
        R.id.action_sair -> {
            startActivity(Intent(this@InicialActivity, MainActivity::class.java))
            return true
        }
        R.id.action_atualizar -> {
            val myIntent = Intent(applicationContext, InicialActivity::class.java)
            startActivityForResult(myIntent, 0)
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

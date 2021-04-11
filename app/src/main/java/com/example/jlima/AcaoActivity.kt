package com.example.jlima

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class AcaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acao)
        // Get the support action bar
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val newString: String?
        newString = if (savedInstanceState == null) {
            val extras = intent.extras
            extras?.getString("titulo")
        } else {
            savedInstanceState.getSerializable("titulo") as String?
        }
        actionBar!!.title = newString;
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
                startActivity(Intent(this@AcaoActivity, LocarActivity::class.java))
                return true
            }
            R.id.action_consultar -> {
                startActivity(Intent(this@AcaoActivity, LocarActivity::class.java))
                return true
            }
            R.id.action_sair -> {
                startActivity(Intent(this@AcaoActivity, MainActivity::class.java))
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
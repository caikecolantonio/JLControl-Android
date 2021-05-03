package com.example.jlima

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_inicial.*
import kotlinx.android.synthetic.main.toolbar.*


class InicialActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)

        // Get the support action bar
        setSupportActionBar(toolbar)
        supportActionBar?.title = "JLima"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


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

        configuraMenuLateral()

    }

    override fun onSupportNavigateUp(): Boolean {
        if (layoutMenuLateral.isDrawerOpen(GravityCompat.START)) {
            layoutMenuLateral.closeDrawer(GravityCompat.START)
        }
        return true
    }

    private fun configuraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar,
            R.string.drawer_abrir,
            R.string.drawer_fechar)
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()
        menu_lateral.setNavigationItemSelectedListener(this)
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
        android.R.id.home -> {
            layoutMenuLateral.openDrawer(GravityCompat.START)
        }
        R.id.action_locar -> {
            startActivity(Intent(this@InicialActivity, LocarActivity::class.java))
            return true
        }
        R.id.action_consultar -> {
            startActivity(Intent(this@InicialActivity, ConsultarActivity::class.java))
            return true
        }
        R.id.action_sair -> {
            startActivity(Intent(this@InicialActivity, MainActivity::class.java))
            return true
        }

    }
    return super.onOptionsItemSelected(item)
}

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_inicial -> {
                startActivity(Intent(this@InicialActivity, InicialActivity::class.java))
            }
            R.id.id_locar -> {
                startActivity(Intent(this@InicialActivity, LocarActivity::class.java))
            }
            R.id.id_consultar -> {
                startActivity(Intent(this@InicialActivity, ConsultarActivity::class.java))
            }
            R.id.id_relatorios -> {
                Toast.makeText(this, "Clicou Relatorios", Toast.LENGTH_SHORT).show()
            }
            R.id.id_logout -> {
                startActivity(Intent(this@InicialActivity, MainActivity::class.java))
            }

        }
// fecha menu depois de tratar o evento
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }



}

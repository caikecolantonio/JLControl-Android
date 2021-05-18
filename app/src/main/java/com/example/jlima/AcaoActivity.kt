package com.example.jlima

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class AcaoActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acao)

        // Get the support action bar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val newString: String?
        newString = if (savedInstanceState == null) {
            val extras = intent.extras
            extras?.getString("titulo")
        } else {
            savedInstanceState.getSerializable("titulo") as String?
        }
        supportActionBar?.title = newString;
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
            R.id.adicionar_terno -> {
                startActivity(Intent(this@AcaoActivity, ListaTernoCadastroActivity::class.java))
                return true
            }
            R.id.action_consultar -> {
                startActivity(Intent(this@AcaoActivity, ConsultarActivity::class.java))
                return true
            }
            R.id.action_sair -> {
                startActivity(Intent(this@AcaoActivity, MainActivity::class.java))
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_inicial -> {
                startActivity(Intent(this@AcaoActivity, InicialActivity::class.java))
            }
            R.id.id_add_terno -> {
                startActivity(Intent(this@AcaoActivity, ListaTernoCadastroActivity::class.java))
            }
            R.id.id_consultar -> {
                startActivity(Intent(this@AcaoActivity, ConsultarActivity::class.java))
            }
            R.id.id_relatorios -> {
                Toast.makeText(this, "Clicou Relatorios", Toast.LENGTH_SHORT).show()
            }
            R.id.id_logout -> {
                startActivity(Intent(this@AcaoActivity, MainActivity::class.java))
            }

        }
// fecha menu depois de tratar o evento
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }



}
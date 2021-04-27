package com.example.jlima

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class InicialActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var drawerLayout: DrawerLayout? = null
    var toggle: ActionBarDrawerToggle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)

        configuraMenuLateral()
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

    private fun configuraMenuLateral() {
        val drawerLayout =DrawerLayout(findViewById(R.id.layoutMenuLateral));
        val navOpenStr = R.string.drawer_abrir
        val navCloseStr = R.string.drawer_fechar

        drawerLayout.addDrawerListener(Teste)
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_locar -> {
                Toast.makeText(this, "Clicou no Locar", Toast.LENGTH_SHORT).show()
            }
            R.id.id_consultar -> {
                Toast.makeText(this, "Clicou Consultar", Toast.LENGTH_SHORT).show()
            }
            R.id.id_relatorios -> {
                Toast.makeText(this, "Clicou Relatorios", Toast.LENGTH_SHORT).show()
            }
        }
// fecha menu depois de tratar o evento
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }



}

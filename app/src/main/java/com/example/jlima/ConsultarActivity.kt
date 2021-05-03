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
import kotlinx.android.synthetic.main.activity_consultar.*
import kotlinx.android.synthetic.main.activity_consultar.layoutMenuLateral
import kotlinx.android.synthetic.main.activity_consultar.menu_lateral
import kotlinx.android.synthetic.main.activity_inicial.*
import kotlinx.android.synthetic.main.toolbar.*


class ConsultarActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
    private var varTernos = listOf<ListaTerno>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)

        // Get the support action bar
        setSupportActionBar(toolbar)
        supportActionBar?.title = "JLima"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recyclerTernos?.layoutManager = LinearLayoutManager(context)
        recyclerTernos?.itemAnimator = DefaultItemAnimator()
        recyclerTernos?.setHasFixedSize(true)
    }


    override fun onResume() {
        super.onResume()
// task para recuperar as disciplinas
        taskTernos()
    }
    fun taskTernos() {
        varTernos = TernoService.getTernos(context)
// atualizar lista
        recyclerTernos?.adapter = TernoAdapter(varTernos) {onClickTerno(it)}
    }
    // tratamento do evento de clicar em uma disciplina
    fun onClickTerno(ternoLista: ListaTerno) {
        Toast.makeText(context, "Clicou terno ${ternoLista.nome}", Toast.LENGTH_SHORT).show()
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
                startActivity(Intent(this@ConsultarActivity, LocarActivity::class.java))
                return true
            }
            R.id.action_consultar -> {
                startActivity(Intent(this@ConsultarActivity, ConsultarActivity::class.java))
                return true
            }
            R.id.action_sair -> {
                startActivity(Intent(this@ConsultarActivity, MainActivity::class.java))
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_inicial -> {
                startActivity(Intent(this@ConsultarActivity, InicialActivity::class.java))
            }
            R.id.id_locar -> {
                startActivity(Intent(this@ConsultarActivity, LocarActivity::class.java))
            }
            R.id.id_consultar -> {
                startActivity(Intent(this@ConsultarActivity, ConsultarActivity::class.java))
            }
            R.id.id_relatorios -> {
                Toast.makeText(this, "Clicou Relatorios", Toast.LENGTH_SHORT).show()
            }
            R.id.id_logout -> {
                startActivity(Intent(this@ConsultarActivity, MainActivity::class.java))
            }
        }
// fecha menu depois de tratar o evento
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }



}

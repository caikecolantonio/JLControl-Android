package com.example.jlima

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
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
        Thread {
        // Código para procurar as trajes
        // que será executado em segundo plano / Thread separada
            varTernos = TernoService.getTernos(context)
            runOnUiThread {
                // Código para atualizar a UI com a lista de trajes
                recyclerTernos?.adapter = TernoAdapter(varTernos) { onClickTerno(it)}
            }
        }.start()
    }


    // tratamento do evento de clicar em um traje
    fun onClickTerno(ternoLista: ListaTerno) {
        Toast.makeText(context, "Clicou terno ${ternoLista.codigo}", Toast.LENGTH_SHORT).show()
        val codigo = ternoLista.codigo
        // verificar qual item foi clicado
        // remover a disciplina no WS
        AlertDialog.Builder(this)
        .setTitle(R.string.app_name)
        .setMessage("Deseja excluir o terno?")
        .setPositiveButton("Sim") {
                dialog, which ->
            dialog.dismiss()
            taskExcluir(codigo)
        }.setNegativeButton("Não") {
                dialog, which -> dialog.dismiss()
        }.create().show()
        }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun taskExcluir(codigo: String) {
        val terno = ListaTerno()
        terno.codigo = codigo
            Thread {
                TernoService.delete(terno as ListaTerno, context)
                runOnUiThread {
                    // após remover, voltar para activity anterior
                    startActivity(Intent(this@ConsultarActivity, ConsultarActivity::class.java))
                }
            }.start()
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
                startActivity(Intent(this@ConsultarActivity, ListaTernoCadastroActivity::class.java))
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
            R.id.id_add_terno -> {
                startActivity(Intent(this@ConsultarActivity, ListaTernoCadastroActivity::class.java))
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

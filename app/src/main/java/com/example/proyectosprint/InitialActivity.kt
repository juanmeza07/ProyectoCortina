package com.example.proyectosprint

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InitialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)
        setSupportActionBar(findViewById(R.id.my_toolbar))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_initial, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId){
            R.id.action_buy -> {
            Toast.makeText(this, R.string.mis_compras, Toast.LENGTH_LONG).show()
                val intento = Intent(this, Registro_ventas::class.java)
                startActivity(intento)
            true
            }

            else -> {
                super.onOptionsItemSelected(item)
                }
        }

    fun onBuy(view: android.view.View) {}
}



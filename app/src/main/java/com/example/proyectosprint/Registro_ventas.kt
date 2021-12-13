package com.example.proyectosprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class Registro_ventas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_recycler)
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }
    /*fun onAb(view: android.view.View){
        val intento = Intent(this, RegistroAbono::class.java)
        startActivity(intento)
    }*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_initial, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
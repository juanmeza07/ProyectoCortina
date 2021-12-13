package com.example.proyectosprint

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
    }

    fun onLogin(view: android.view.View) {
        if (edtUsername.text.toString().equals("vicentslein@gmail.com") && edtPassword.text.toString().equals("1234")){
            val intento = Intent(this, InitialActivity::class.java)
            intento.putExtra("username", edtUsername.text.toString() )
            startActivity(intento)
        }
    }


}

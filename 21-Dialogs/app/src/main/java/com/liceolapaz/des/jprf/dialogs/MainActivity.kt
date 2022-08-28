package com.liceolapaz.des.jprf.dialogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnAlerta : Button
    private lateinit var btnConfirmacion : Button
    private lateinit var btnSeleccion : Button
    private lateinit var btnPersonalizado : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAlerta = findViewById(R.id.btnAlerta)
        btnAlerta.setOnClickListener {
            DialogoAlerta().show(supportFragmentManager, DialogoAlerta.TAG)
        }

        btnConfirmacion = findViewById(R.id.btnConfirmacion)
        btnConfirmacion.setOnClickListener {
            DialogoConfirmacion().show(supportFragmentManager, DialogoConfirmacion.TAG)
        }

        btnSeleccion = findViewById(R.id.btnSeleccion)
        btnSeleccion.setOnClickListener {
            DialogoSeleccion().show(supportFragmentManager, DialogoSeleccion.TAG)
        }

        btnPersonalizado = findViewById(R.id.btnPersonalizado)
        btnPersonalizado.setOnClickListener {
            DialogoPersonalizado().show(supportFragmentManager, DialogoPersonalizado.TAG)
        }
    }
}
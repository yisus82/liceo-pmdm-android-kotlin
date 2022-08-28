package com.liceolapaz.des.jprf.controlpersonalizado3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var lblCasilla : TextView
    private lateinit var terTablero : TresEnRaya
    private lateinit var btnFicha : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lblCasilla = findViewById(R.id.lblCasilla)

        terTablero = findViewById(R.id.tablero)
        terTablero.setOnCasillaSeleccionadaListener { fila, columna ->
            lblCasilla.text = "Última casilla seleccionada: ($fila, $columna)"
        }

        btnFicha = findViewById(R.id.btnFicha)
        btnFicha.setOnClickListener {
            terTablero.alternarFichaActiva()
        }
    }
}
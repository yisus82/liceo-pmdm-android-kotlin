package com.liceolapaz.des.jprf.botones

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var lblMensaje: TextView
    private lateinit var btnBotonSimple: Button
    private lateinit var btnBotonMasImagen: Button
    private lateinit var btnToggle: ToggleButton
    private lateinit var btnSwitch: Switch
    private lateinit var btnImagen: ImageButton
    private lateinit var btnPersonalizado: ToggleButton
    private lateinit var btnSinBorde1: Button
    private lateinit var btnSinBorde2: ImageButton
    private lateinit var btnAceptar: Button
    private lateinit var btnCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lblMensaje = findViewById(R.id.lblMensaje)

        btnBotonSimple = findViewById(R.id.btnBotonSimple)
        btnBotonSimple.setOnClickListener {
            lblMensaje.text = "Botón Simple pulsado!"
        }

        btnBotonMasImagen = findViewById(R.id.btnBotonMasImagen)
        btnBotonMasImagen.setOnClickListener {
            lblMensaje.text = "Botón texto+imagen pulsado!"
        }

        btnToggle = findViewById(R.id.btnToggle)
        btnToggle.setOnClickListener {
            if (btnToggle.isChecked) {
                lblMensaje.text = "Botón Toggle: ON"
            } else {
                lblMensaje.text = "Botón Toggle: OFF"
            }
        }

        btnSwitch = findViewById(R.id.btnSwitch)
        btnSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                lblMensaje.text = "Botón Switch: ON"
            } else {
                lblMensaje.text = "Botón Switch: OFF"
            }
        }

        btnImagen = findViewById(R.id.btnImagen)
        btnImagen.setOnClickListener {
            lblMensaje.text = "Botón Imagen pulsado!"
        }

        btnPersonalizado = findViewById(R.id.btnPersonalizado)
        btnPersonalizado.setOnClickListener {
            if (btnPersonalizado.isChecked) {
                lblMensaje.text = "Botón Personalizado: ON"
            } else {
                lblMensaje!!.text = "Botón Personalizado: OFF"
            }
        }

        btnSinBorde1 = findViewById(R.id.btnSinBorde1)
        btnSinBorde1.setOnClickListener {
            lblMensaje.text = "Botón Sin Borde 1 pulsado!"
        }

        btnSinBorde2 = findViewById(R.id.btnSinBorde2)
        btnSinBorde2.setOnClickListener {
            lblMensaje.text = "Botón Sin Borde 2 pulsado!"
        }

        btnAceptar = findViewById(R.id.btnAceptar)
        btnAceptar.setOnClickListener {
            lblMensaje.text = "Botón Aceptar pulsado!"
        }

        btnCancelar = findViewById(R.id.btnCancelar)
        btnCancelar.setOnClickListener {
            lblMensaje.text = "Botón Cancelar pulsado!"
        }
    }
}
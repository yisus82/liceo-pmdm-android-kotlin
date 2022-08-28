package com.liceolapaz.des.jprf.snackbar

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var btnSnackbarSimple : Button
    private lateinit var btnSnackbarAccion : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSnackbarSimple = findViewById(R.id.btnSimple)
        btnSnackbarSimple.setOnClickListener {
            Snackbar.make(it, "Esto es una prueba", Snackbar.LENGTH_LONG)
                .show()
        }

        btnSnackbarAccion = findViewById(R.id.btnAccion)
        btnSnackbarAccion.setOnClickListener {
            Snackbar.make(it, "Esto es otra prueba", Snackbar.LENGTH_LONG)
                .setActionTextColor(ContextCompat.getColor(baseContext, R.color.snackbar_action))
                .setAction("Acción") {
                    Log.i("Snackbar", "Pulsada acción snackbar!");
                }
                .show()
        }
    }
}
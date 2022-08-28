package com.liceolapaz.des.jprf.toast

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnDefecto : Button
    private lateinit var btnGravity : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDefecto = findViewById<View>(R.id.btnPorDefecto) as Button
        btnGravity = findViewById<View>(R.id.btnGravity) as Button

        btnDefecto.setOnClickListener {
            Toast.makeText(applicationContext, R.string.toast_por_defecto, Toast.LENGTH_SHORT).show()
        }

        btnGravity.setOnClickListener {
            Toast.makeText(applicationContext, R.string.toast_gravity, Toast.LENGTH_SHORT)
                    .apply {
                        setGravity(Gravity.CENTER or Gravity.RIGHT, 0, 0)
                        show()
                    }
        }
    }
}
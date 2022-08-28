package com.liceolapaz.des.jprf.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class DetalleActivity : AppCompatActivity() {
    companion object {
        val EXTRA_TEXTO : String = "com.liceolapaz.des.jprf.fragments.EXTRA_TEXTO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val detalle = supportFragmentManager.findFragmentById(R.id.frgDetalle) as FragmentDetalle
        detalle.actualizarDetalle(intent.getStringExtra(EXTRA_TEXTO))
    }
}
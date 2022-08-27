package com.liceolapaz.des.jprf.recyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var btnInsertar : Button
    private lateinit var btnEliminar : Button
    private lateinit var btnMover : Button
    private lateinit var recView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInsertar = findViewById(R.id.btnInsertar)
        btnEliminar = findViewById(R.id.btnEliminar)
        btnMover = findViewById(R.id.btnMover)
        recView = findViewById(R.id.recView)

        val datos = MutableList(50) {
                i -> Titular("Título $i", "Subtítulo $i")
        }

        val adaptador = AdaptadorTitulares(datos) {
            Log.i("RecyclerView", "Pulsado el elemento: ${it.titulo}")
        }

        recView.setHasFixedSize(true)

        //1. Linear Layout Manager
        recView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //2. Grid Layout Manager
        //recView.layoutManager = GridLayoutManager(this, 3)

        recView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        recView.itemAnimator = DefaultItemAnimator()

        recView.adapter = adaptador

        btnInsertar.setOnClickListener {
            datos.add(1, Titular("Nuevo Título", "Nuevo Subtítulo"))
            adaptador.notifyItemInserted(1)
        }

        btnEliminar.setOnClickListener {
            datos.removeAt(1)
            adaptador.notifyItemRemoved(1)
        }

        btnMover.setOnClickListener {
            datos[1] = datos[2].also { datos[2] = datos[1] }
            adaptador.notifyItemMoved(1, 2)
        }
    }
}
package com.liceolapaz.des.jprf.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liceolapaz.des.jprf.fragments.AdaptadorCorreos
import com.liceolapaz.des.jprf.fragments.Correo
import com.liceolapaz.des.jprf.fragments.CorreosListener
import com.liceolapaz.des.jprf.fragments.R

class FragmentListado : Fragment() {
    private lateinit var lstListado : RecyclerView
    private lateinit var listener : CorreosListener

    private val datos =
        MutableList(5) { i -> Correo("Persona $i", "Asunto del correo $i", "Texto del correo $i") }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_listado, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adaptador = AdaptadorCorreos(datos) {
            listener.onCorreoSeleccionado(it)
        }

        lstListado = view.findViewById(R.id.lstListado)
        lstListado.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        lstListado.addItemDecoration(
            DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
        )
        lstListado.adapter = adaptador
    }

    fun setCorreosListener(seleccion: (Correo) -> Unit) {
        listener = object: CorreosListener {
            override fun onCorreoSeleccionado(correo: Correo) {
                seleccion(correo)
            }
        }
    }
}
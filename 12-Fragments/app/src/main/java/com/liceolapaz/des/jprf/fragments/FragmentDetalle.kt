package com.liceolapaz.des.jprf.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.liceolapaz.des.jprf.fragments.DetalleActivity.Companion.EXTRA_TEXTO

class FragmentDetalle : Fragment() {
    var detalle : String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mostrarDetalle(view, detalle)
    }

    private fun mostrarDetalle(view: View?, detalle: String?) {
        if (view != null) {
            val txtDetalle = view.findViewById(R.id.txtDetalle) as TextView
            txtDetalle.text = detalle
        }
    }

    fun actualizarDetalle(texto: String?) {
        detalle = texto
        mostrarDetalle(view, detalle)
    }
}
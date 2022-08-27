package com.liceolapaz.des.jprf.imagentexto

import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.Spannable
import android.text.style.StyleSpan
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.TextView.BufferType

class MainActivity : AppCompatActivity() {
    private lateinit var imgLogo : ImageView
    private lateinit var lblEtiqueta : TextView
    private lateinit var txtBasico : EditText
    private lateinit var btnSetText : Button
    private lateinit var btnNegrita : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Establecer propiedades de la imagen por código:
        imgLogo = findViewById(R.id.imgLogo)
        imgLogo.setImageResource(R.drawable.logoandroid)
        imgLogo.setOnClickListener {
            txtBasico.setText("Logo pulsado")
        }

        //Estalecer propiedades de la etiqueta de texto por código:
        lblEtiqueta = findViewById(R.id.lblEtiqueta)
        val texto = lblEtiqueta.text.toString()
        lblEtiqueta.text = "$texto (modificado)"
        lblEtiqueta.setBackgroundColor(Color.RED)

        //Establecer propiedades del cuadro de texto por código:
        txtBasico = findViewById(R.id.txtBasico)
        txtBasico.setText("Otro texto")

        /*
        //Convertir HTML a Spannable
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtBasico.setText(
                Html.fromHtml("<p>Esto es un <b>simulacro</b>.</p>", Html.FROM_HTML_MODE_LEGACY),
                BufferType.SPANNABLE);
        }

        //Convertir a HTML el contenido del control
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val nuevoTexto = Html.toHtml(txtBasico.text, Html.TO_HTML_PARAGRAPH_LINES_INDIVIDUAL)

            //Asigna texto sin formato (incluirá todas las etiquetas HTML)
            txtBasico.setText(nuevoTexto)

            //Asigna texto con formato HTML
            txtBasico.setText(Html.fromHtml(nuevoTexto, Html.FROM_HTML_MODE_LEGACY), BufferType.SPANNABLE)

            //Obtiene el texto SIN etiquetas de formato HTML
            val aux1 = txtBasico.text.toString()

            //Obtiene el texto CON etiquetas de formato HTML
            val aux2 = Html.toHtml(txtBasico.text, Html.TO_HTML_PARAGRAPH_LINES_INDIVIDUAL);
        }
        */

        btnSetText = findViewById(R.id.btnSetText)
        btnSetText.setOnClickListener {
            //Creamos un nuevo objeto de tipo Editable
            //Y marcamos como fuente negrita la palabra "simulacro" (caracteres del 11-19)
            val str = Editable.Factory.getInstance().newEditable("Esto es un simulacro.")
            str.setSpan(StyleSpan(Typeface.BOLD), 11, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            txtBasico.text = str
        }

        btnNegrita = findViewById(R.id.btnNegrita)
        btnNegrita.setOnClickListener {
            val texto = txtBasico.text
            val ini = txtBasico.selectionStart
            val fin = txtBasico.selectionEnd

            texto.setSpan(
                StyleSpan(Typeface.BOLD),
                ini, fin,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }
}
package com.liceolapaz.des.jprf.controlpersonalizado2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var ctlLogin : ControlLogin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ctlLogin = findViewById(R.id.ctlLogin)

        ctlLogin.setOnLoginListener { usuario, password ->
            if(usuario == "demo" && password == "demo") {
                ctlLogin.setMensaje("Login correcto!")
            } else {
                ctlLogin.setMensaje("Vuelve a intentarlo")
            }
        }
    }
}
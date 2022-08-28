package com.liceolapaz.des.jprf.bbdd1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        val usdbh = UsuariosSQLiteHelper(this, "DBUsuarios", null, 1)

        val db = usdbh.writableDatabase

        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            //Insertamos 5 usuarios de ejemplo
            for (i in 1..5) {
                //Generamos los datos
                val nombre = "Usuario$i"

                //Insertamos los datos en la tabla Usuarios
                db.execSQL(
                    "INSERT INTO Usuarios (codigo, nombre) VALUES ($i, '$nombre')"
                )
            }

            //Cerramos la base de datos
            db.close()
        }

    }
}
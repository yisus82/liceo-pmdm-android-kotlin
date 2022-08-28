package com.liceolapaz.des.jprf.bbdd3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UsuariosSQLiteHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    //Sentencia SQL para crear la tabla de Usuarios
    val sqlCreate = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)"

    override fun onCreate(db: SQLiteDatabase?) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db?.execSQL(sqlCreate)
    }

    override fun onUpgrade(db: SQLiteDatabase?, previousVersion: Int, newVersion: Int) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente
        //      la opción de eliminar la tabla anterior y crearla de nuevo
        //      vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la
        //      tabla antigua a la nueva, por lo que este método debería
        //      ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db?.execSQL("DROP TABLE IF EXISTS Usuarios")

        //Se crea la nueva versión de la tabla
        db?.execSQL(sqlCreate)
    }
}
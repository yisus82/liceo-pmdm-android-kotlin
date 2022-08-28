package com.liceolapaz.des.jprf.bbdd3

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var txtCodigo: EditText
    private lateinit var txtNombre: EditText
    private lateinit var txtResultado: TextView
    private lateinit var btnInsertar: Button
    private lateinit var btnActualizar: Button
    private lateinit var btnEliminar: Button
    private lateinit var btnConsultar: Button
    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obtenemos las referencias a los controles
        txtCodigo = findViewById<View>(R.id.txtReg) as EditText
        txtNombre = findViewById<View>(R.id.txtVal) as EditText
        txtResultado = findViewById<View>(R.id.txtResultado) as TextView
        btnInsertar = findViewById<View>(R.id.btnInsertar) as Button
        btnActualizar = findViewById<View>(R.id.btnActualizar) as Button
        btnEliminar = findViewById<View>(R.id.btnEliminar) as Button
        btnConsultar = findViewById<View>(R.id.btnConsultar) as Button

        //Abrimos la base de datos 'DBUsuarios' en modo escritura
        val usdbh = UsuariosSQLiteHelper(this, "DBUsuarios", null, 1)
        db = usdbh.writableDatabase

        btnInsertar.setOnClickListener {
            //Recuperamos los valores de los campos de texto
            val cod = txtCodigo.text.toString()
            val nom = txtNombre.text.toString()

            //Alternativa 1: método sqlExec()
            val sql = "INSERT INTO Usuarios (codigo,nombre) VALUES ('$cod','$nom')"
            db.execSQL(sql)

            //Alternativa 2: método insert()
            //val nuevoRegistro = ContentValues()
            //nuevoRegistro.put("codigo", cod)
            //nuevoRegistro.put("nombre", nom)
            //db.insert("Usuarios", null, nuevoRegistro)
        }

        btnActualizar.setOnClickListener {
            //Recuperamos los valores de los campos de texto
            val cod = txtCodigo.text.toString()
            val nom = txtNombre.text.toString()

            //Alternativa 1: método sqlExec()
            val sql = "UPDATE Usuarios SET nombre='$nom' WHERE codigo=$cod"
            db.execSQL(sql)

            //Alternativa 2: método update()
            //val valores = ContentValues()
            //valores.put("nombre", nom)
            //db.update("Usuarios", valores, "codigo=$cod", null)
        }

        btnEliminar.setOnClickListener {
            //Recuperamos los valores de los campos de texto
            val cod = txtCodigo.text.toString()

            //Alternativa 1: método sqlExec()
            val sql = "DELETE FROM Usuarios WHERE codigo=$cod"
            db.execSQL(sql)

            //Alternativa 2: método delete()
            //db.delete("Usuarios", "codigo=$cod", null);
        }

        btnConsultar.setOnClickListener {
            //Alternativa 1: método rawQuery()
            val c: Cursor = db.rawQuery("SELECT codigo, nombre FROM Usuarios", null)

            //Alternativa 2: método query()
            //val campos = arrayOf("codigo", "nombre")
            //val c: Cursor = db.query("Usuarios", campos, null, null, null, null, null)

            //Recorremos los resultados para mostrarlos en pantalla
            txtResultado.text = ""
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    val cod: String = c.getString(0)
                    val nom: String = c.getString(1)
                    txtResultado.append("$cod - $nom\n")
                } while (c.moveToNext())
            }
        }
    }
}
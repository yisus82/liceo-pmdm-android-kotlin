package com.liceolapaz.des.jprf.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoSeleccion : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val items = arrayOf("Español", "Inglés", "Francés")
        val itemsChecked = BooleanArray(3)

        return AlertDialog.Builder(requireContext())
            .setTitle("Selección")
            .setItems(items) { dialog, item ->
                Log.i("Dialogos", "Opción elegida: " + items[item])
                dialog.dismiss()
            }
//            .setMultiChoiceItems(items, itemsChecked) { dialog, position, isChecked ->
//                itemsChecked[position] = isChecked
//                Log.i("Dialogos", "Opción marcada: " + items[position])
//            }
//            .setSingleChoiceItems(items, -1) { dialog, position ->
//                Log.i("Dialogos", "Opción elegida: " + items[position])
//            }
            .create()
    }

    companion object {
        const val TAG = "DialogoSeleccion"
    }
}
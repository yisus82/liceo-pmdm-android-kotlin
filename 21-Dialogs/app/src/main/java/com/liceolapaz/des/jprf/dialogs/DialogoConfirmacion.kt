package com.liceolapaz.des.jprf.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoConfirmacion : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage("¿Confirma la acción seleccionada?")
            .setTitle("Confirmacion")
            .setPositiveButton("Aceptar") { dialog, _ ->
                Log.i("Dialogos", "Confirmacion aceptada")
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar"){ dialog, _ ->
                Log.i("Dialogos", "Confirmacion cancelada")
                dialog.dismiss()
            }
            .create()

    companion object {
        const val TAG = "DialogoConfirmacion"
    }
}
package com.liceolapaz.des.jprf.dialogs

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoAlerta : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage("Esto es un mensaje de alerta.")
            .setTitle("Información")
            .setPositiveButton("OK") { dialog, _ ->
                Log.i("Dialogos", "OK pulsado")
                dialog.dismiss()
            }
            .create()

    companion object {
        const val TAG = "DialogoAlerta"
    }
}
package com.liceolapaz.des.jprf.dialogs

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoPersonalizado : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = activity?.layoutInflater

        return AlertDialog.Builder(requireContext())
            .setView(inflater?.inflate(R.layout.dialogo_personalizado, null))
            .setPositiveButton("Aceptar") { dialog, _ ->
                Log.i("Dialogos", "Aceptar pulsado")
                dialog.dismiss()
            }
            .create()
    }

    companion object {
        const val TAG = "DialogoPersonalizado"
    }
}
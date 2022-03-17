package com.mirkamol.notesapproomdatabase.database.entity

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import com.mirkamol.notesapproomdatabase.R

class ViewDialog(private val context: Context, private val listener:OnItemClicked) {

    interface OnItemClicked{
        fun onDialogClicked(title:String, currentDate:String)
    }

    fun openNewNoteDialog() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.custom_dialog_view)

        val edittextTile = dialog.findViewById<EditText>(R.id.edittext_title)
        val edittextNote = dialog.findViewById<EditText>(R.id.edittext_note)

        val tvCancel = dialog.findViewById<TextView>(R.id.tv_cancel)

        tvCancel.setOnClickListener {
            dialog.dismiss()
        }

        val tvSave = dialog.findViewById<TextView>(R.id.tv_save)

        tvSave.setOnClickListener {
            listener.onDialogClicked(edittextTile.text.toString(), edittextNote.text.toString())
            dialog.dismiss()
        }


        dialog.show()
    }
}


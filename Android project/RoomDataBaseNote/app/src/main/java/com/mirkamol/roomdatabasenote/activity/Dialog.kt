package com.mirkamol.roomdatabasenote.activity

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.EditText
import com.mirkamol.roomdatabasenote.R

class Dialog(private val context: Context, private val listener: OnItemClicked) {

    private val TYPE_ITEM_CONFIRM = 0
    private val TYPE_ITEM_VIEW = 1
    interface OnItemClicked {
        fun onDialogClicked(title: String, body: String)
    }


    fun openNewNotedialog() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)

        if (TYPE_ITEM_CONFIRM == 0){
            dialog.setContentView(R.layout.custom_dialog_view)
        }else if (TYPE_ITEM_VIEW == 1){
            dialog.setContentView(R.layout.custom_dialog)

            val edittextTile = dialog.findViewById<EditText>(R.id.edittext_title_confirm)
            val edittextBody = dialog.findViewById<EditText>(R.id.edittext_note_confirm)

            val btnSave = dialog.findViewById<Button>(R.id.tv_confirm)
            btnSave.setOnClickListener {
                listener.onDialogClicked(edittextTile.text.toString(), edittextBody.text.toString())
                dialog.dismiss()
            }
        }

        Log.d("@@@", "Jalol")

        val edittextTile = dialog.findViewById<EditText>(R.id.edittext_title)
        val edittextBody = dialog.findViewById<EditText>(R.id.edittext_note)

        val btnCancel = dialog.findViewById<Button>(R.id.tv_cancel)
        val btnSave = dialog.findViewById<Button>(R.id.tv_save)

        btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        btnSave.setOnClickListener {
            listener.onDialogClicked(edittextTile.text.toString(), edittextBody.text.toString())
            dialog.dismiss()
        }

        dialog.show()


    }

    fun openNewNotedialogConfirm() {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)


        Log.d("@@@", "Jalol")






        dialog.show()
    }
}
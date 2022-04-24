package com.cwise.teacherappkotlin.models

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.TextView
import com.cwise.teacherappkotlin.R

object Loading {
    var dialog: Dialog? = null //obj
    fun show(context: Context?) { // function -- context(parent (reference))
        dialog = Dialog(context!!)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setContentView(R.layout.loading_dialog)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog!!.setCancelable(false)
        val textView = dialog!!.findViewById<TextView>(R.id.textView3)
        textView.text = "Please wait..."
        try {
            dialog!!.show()
        } catch (e: Exception) {
        }
    }

    fun dismiss() {
        try {
            if (dialog != null) {
                dialog!!.dismiss()
            }
        } catch (e: Exception) {
        }
    }
}
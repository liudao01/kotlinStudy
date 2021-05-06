package com.example.kotlin.study

import android.app.Dialog
import android.content.Context

/**
 * Created by liuml on 2021/5/6 09:10
 */
//没有主构造也没有次构造
object LoadingDialog {

    private var dialog: Dialog? = null

    fun show(context: Context) {
        cancel()

        dialog = Dialog(context)
        dialog?.setContentView(R.layout.dialog_loading)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()


    }

    fun cancel() {
        dialog?.dismiss()
        dialog = null
    }
}
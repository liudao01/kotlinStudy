package com.example.kotlin.study.modules.register.inter

import android.content.Context
import com.example.kotlin.study.base.IBasePresenter
import com.example.kotlin.study.entity.LoginRegisterResponse

interface RegisterPresenter : IBasePresenter {

    fun registerWanAndroid(context: Context, username: String, password: String, repassword: String)

    // M  ---》 P  接口监听
    interface OnRegisterListener {

        fun registerSuccess(registerBean: LoginRegisterResponse?)

        fun registerFailed(errorMsg: String?)

    }

}
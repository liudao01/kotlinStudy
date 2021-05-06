package com.example.kotlin.study.modules.register.inter

import android.content.Context

interface RegisterModule {

    fun cancelRequest()

    fun register(
        context: Context,
        username: String,
        password: String,
        repassword: String,

        // 把结果 给 P层  接口回调
        callback: RegisterPresenter.OnRegisterListener
    )

}
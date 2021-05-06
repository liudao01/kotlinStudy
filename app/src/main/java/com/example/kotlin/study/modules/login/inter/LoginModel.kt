package com.example.kotlin.study.modules.login.inter

import android.content.Context

/**
 * Created by liuml on 2021/5/6 14:00
 */
interface LoginModel {


    // 取消请求 动作
    fun cancelRequest()

    // 登录
    fun login(
        context: Context,
        username: String,
        password: String,

        // 接口回调，把data 结果，给P层
        onLoginListener: LoginPresenter.OnLoginListener
    )

}
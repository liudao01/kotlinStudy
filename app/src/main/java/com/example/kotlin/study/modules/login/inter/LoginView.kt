package com.example.kotlin.study.modules.login.inter

import com.example.kotlin.study.entity.LoginRegisterResponse

/**
 * view层
 * Created by liuml on 2021/5/6 13:51
 */


interface LoginView {

    //把结果显示到activity/fragment

    fun loginSuccess(loginRegisterBean: LoginRegisterResponse?)

    fun longinFialure(error: String?)
}
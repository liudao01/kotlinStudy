package com.example.kotlin.study.modules.login.inter

import android.content.Context
import com.example.kotlin.study.base.IBasePersenter
import com.example.kotlin.study.entity.LoginRegisterResponse

/**
 * Created by liuml on 2021/5/6 14:01
 */
interface LoginPresenter : IBasePersenter {
    // 登录
    fun loginAction(context: Context, username: String, password: String)

    // 监听回调
    interface OnLoginListener {

        fun loginSuccess(loginBean: LoginRegisterResponse?)

        fun loginFialure(erroeMsg: String?)

    }
}
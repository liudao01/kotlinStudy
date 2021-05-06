package com.example.kotlin.study.modules.register.inter

import com.example.kotlin.study.entity.LoginRegisterResponse

interface RegisterView {

    // 成功 失败 显示 到 Activty

    fun registerSuccess(registerBean: LoginRegisterResponse?)

    fun registerFailed(errorMsg: String?)


}
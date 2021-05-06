package com.example.kotlin.study.modules.login

import android.content.Context
import com.example.kotlin.study.entity.LoginRegisterResponse
import com.example.kotlin.study.modules.login.inter.LoginPresenter
import com.example.kotlin.study.modules.login.inter.LoginView

/**
 * Created by liuml on 2021/5/6 14:28
 */
class LoginPresenterImpl(var loginView: LoginView?) : LoginPresenter,
    LoginPresenter.OnLoginListener {

    //M层
    var loginModel: LoginModelImpl = LoginModelImpl()

    override fun loginAction(context: Context, username: String, password: String) {

        //可以做校验
        loginModel.login(context, username, password, this)
    }

    override fun unAttachView() {
        loginView = null
        loginModel.cancelRequest() // 取消请求
    }

    override fun loginSuccess(loginBean: LoginRegisterResponse?) {

        loginView?.loginSuccess(loginBean)

    }

    override fun loginFialure(erroeMsg: String?) {

        loginView?.longinFialure(erroeMsg)

    }
}
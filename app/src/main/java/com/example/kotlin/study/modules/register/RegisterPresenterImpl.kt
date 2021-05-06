package com.example.kotlin.study.modules.register

import android.content.Context
import com.example.kotlin.study.entity.LoginRegisterResponse
import com.example.kotlin.study.modules.register.inter.RegisterPresenter
import com.example.kotlin.study.modules.register.inter.RegisterView

class RegisterPresenterImpl constructor(var view: RegisterView?) : RegisterPresenter
, RegisterPresenter.OnRegisterListener

{

    // 需要  M 去请求 拿业务数据         搞定
    private val model = RegisterModuleImpl()

    // 需要 V 拿到响应数据后   给 UI     搞定

    override fun registerWanAndroid(
        context: Context,
        username: String,
        password: String,
        repassword: String
    ) {
        // TODO
        // 可以做很多的事情
        // 可以省略很多代码
        // 很多的校验
        // ....

        model.register(context, username, password, repassword, this)
    }

    override fun unAttachView() {
        view = null
        model.cancelRequest()
    }

    // 响应的数据
    override fun registerSuccess(registerBean: LoginRegisterResponse?) {
        // TODO
        // 可以做很多的事情
        // 可以省略很多代码
        // 很多的校验
        // ....

        view?.registerSuccess(registerBean)
    }

    override fun registerFailed(errorMsg: String?) {
        // TODO
        // 可以做很多的事情
        // 可以省略很多代码
        // 很多的校验
        // ....

        view?.registerFailed(errorMsg)
    }


}
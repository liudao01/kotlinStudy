package com.example.kotlin.study.modules.register

import android.content.Context
import com.example.kotlin.study.api.WanAndroidApi
import com.example.kotlin.study.entity.LoginRegisterResponse
import com.example.kotlin.study.modules.register.inter.RegisterModule
import com.example.kotlin.study.modules.register.inter.RegisterPresenter
import com.example.kotlin.study.net.APIClent
import com.example.kotlin.study.net.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RegisterModuleImpl : RegisterModule {

    // 取消请求
    override fun cancelRequest() {}

    override fun register(
        context: Context,
        username: String,
        password: String,
        repassword: String,
        callback: RegisterPresenter.OnRegisterListener
    ) {
        // 网络模型
        APIClent.instance.instanceRetrofit(WanAndroidApi::class.java)
            .registerAction(username, password, repassword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiResponse<LoginRegisterResponse>(context) {
                override fun success(data: LoginRegisterResponse?) {
                    callback.registerSuccess(data)
                }

                override fun failure(errorMsg: String?) {
                    callback.registerFailed(errorMsg)
                }

            })
    }
}
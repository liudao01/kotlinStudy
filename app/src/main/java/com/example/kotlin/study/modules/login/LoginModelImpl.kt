package com.example.kotlin.study.modules.login

import android.content.Context
import android.util.Log
import com.example.kotlin.study.api.WanAndroidApi
import com.example.kotlin.study.config.Flag
import com.example.kotlin.study.entity.LoginRegisterResponse
import com.example.kotlin.study.modules.login.inter.LoginModel
import com.example.kotlin.study.modules.login.inter.LoginPresenter
import com.example.kotlin.study.net.APIClent
import com.example.kotlin.study.net.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by liuml on 2021/5/6 14:30
 */
class LoginModelImpl : LoginModel {
    //取消请求
    override fun cancelRequest() {

    }

    override fun login(
        context: Context,
        username: String,
        password: String,
        onLoginListener: LoginPresenter.OnLoginListener
    ) {
        APIClent.instance.instanceRetrofit(WanAndroidApi::class.java)
            .loginAciton(username, password)
            .subscribeOn(Schedulers.io())//分配异步线程
            .observeOn(AndroidSchedulers.mainThread())//给下面更新UI操作，回到主线程

            /*.subscribe(object : Consumer<LoginResponseWrapper<LoginResponse>> {
                                 override fun accept(t: LoginResponseWrapper<LoginResponse>?) {
                                     // 我这里是更新UI，拿到了包装Bean，实际上我不需要包装Bean
                                 }

                             })*/
            .subscribe(object : ApiResponse<LoginRegisterResponse>(context) {
                override fun success(data: LoginRegisterResponse?) {

                    onLoginListener.loginSuccess(data)
                }

                override fun failure(errorMsg: String?) {
//                    Log.d(Flag.TAG, "登录失败 ${errorMsg}")
                    onLoginListener.loginFialure(errorMsg)
                }

            })
    }
}
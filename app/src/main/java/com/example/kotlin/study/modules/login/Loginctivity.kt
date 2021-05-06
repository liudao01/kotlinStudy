package com.example.kotlin.study.modules.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.study.R
import com.example.kotlin.study.api.WanAndroidApi
import com.example.kotlin.study.config.Flag
import com.example.kotlin.study.entity.LoginResponse
import com.example.kotlin.study.net.APIClent
import com.example.kotlin.study.net.ApiResponse
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*

/**
 * 登录界面
 */
class Loginctivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener(onclickListener)
    }

    var onclickListener = View.OnClickListener {
        when (it.id) {
            R.id.login->{
                var name = username.text.toString()
                var pwd = password.text.toString()

                Log.d(Flag.TAG, "userName:$name,  userPwd:$pwd")
                APIClent.instance.instanceRetrofit(WanAndroidApi::class.java)
                    .loginAciton(name,pwd)
                    .subscribeOn(Schedulers.io())//分配异步线程
                    .observeOn(AndroidSchedulers.mainThread())//给下面更新UI操作，回到主线程

                /*.subscribe(object : Consumer<LoginResponseWrapper<LoginResponse>> {
                                     override fun accept(t: LoginResponseWrapper<LoginResponse>?) {
                                         // 我这里是更新UI，拿到了包装Bean，实际上我不需要包装Bean
                                     }

                                 })*/
                    .subscribe(object : ApiResponse<LoginResponse>(this){
                        override fun success(data: LoginResponse?) {
                            Log.d(Flag.TAG, "登录成功 ${data.toString()}")
                        }

                        override fun failure(errorMsg: String?) {
                            Log.d(Flag.TAG, "登录失败 ${errorMsg}")
                        }

                    })

            }
        }
    }
}




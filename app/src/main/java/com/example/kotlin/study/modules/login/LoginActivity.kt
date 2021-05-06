package com.example.kotlin.study.modules.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.kotlin.study.MainActivity
import com.example.kotlin.study.R
import com.example.kotlin.study.base.BaseActivity
import com.example.kotlin.study.config.Flag
import com.example.kotlin.study.entity.LoginRegisterResponse
import com.example.kotlin.study.modules.login.inter.LoginPresenter
import com.example.kotlin.study.modules.login.inter.LoginView
import kotlinx.android.synthetic.main.activity_login.*

/**
 * 登录界面
 */
class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //可以用viewbinding 暂时不弄了
        login.setOnClickListener(onclickListener)
        username.setText("liudao01")
        password.setText("liudao7994")
    }

    var onclickListener = View.OnClickListener {
        when (it.id) {
            R.id.login -> {
                var name = username.text.toString()
                var pwd = password.text.toString()

                Log.d(Flag.TAG, "userName:$name,  userPwd:$pwd")
                presenter.loginAction(this, name, pwd)

            }
        }
    }

    override fun createP(): LoginPresenter {
        Log.d(Flag.TAG, "初始化presenter")
        return LoginPresenterImpl(this)
    }

    override fun recycle() {
        presenter.unAttachView()
    }

    override fun loginSuccess(loginRegisterBean: LoginRegisterResponse?) {
        Log.d(Flag.TAG, "登录成功 ${loginRegisterBean}")
        Toast.makeText(this@LoginActivity, "登录成功😀", Toast.LENGTH_SHORT).show()
        var intent : Intent = Intent()
        intent.setClass(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
    }

    override fun longinFialure(error: String?) {
        Log.d(Flag.TAG, "登录失败 ${error}")
        Toast.makeText(this@LoginActivity, "登录失败 ~", Toast.LENGTH_SHORT).show()
    }
}




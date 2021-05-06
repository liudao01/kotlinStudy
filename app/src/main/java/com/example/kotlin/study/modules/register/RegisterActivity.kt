package com.example.kotlin.study.modules.register

import android.os.Bundle
import android.widget.Toast
import com.example.kotlin.study.R
import com.example.kotlin.study.base.BaseActivity
import com.example.kotlin.study.entity.LoginRegisterResponse
import com.example.kotlin.study.modules.register.inter.RegisterPresenter
import com.example.kotlin.study.modules.register.inter.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity<RegisterPresenter>(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        hideActionBar()

        setContentView(R.layout.activity_register)

        register.setOnClickListener {
            //调用注册
            val usernameStr = username.text.toString()
            val passwordStr = password.text.toString()
            presenter.registerWanAndroid(this@RegisterActivity, usernameStr, passwordStr, passwordStr)
        }
    }

    override fun createP(): RegisterPresenter = RegisterPresenterImpl(this)

    override fun recycle() {
        presenter.unAttachView()
    }

    override fun registerSuccess(registerBean: LoginRegisterResponse?) {
        Toast.makeText(this, "注册成功😀", Toast.LENGTH_SHORT).show()
    }

    override fun registerFailed(errorMsg: String?) {
        Toast.makeText(this, "注册失败 ", Toast.LENGTH_SHORT).show()
    }
}
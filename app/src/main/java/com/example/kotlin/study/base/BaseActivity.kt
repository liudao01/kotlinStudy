package com.example.kotlin.study.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.study.config.Flag

/**
 * Created by liuml on 2021/5/6 12:28
 */
abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter {

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Flag.TAG, "BaseActivity onCreate 方法")
        presenter = createP()
    }

    abstract fun createP(): P


    abstract fun recycle()

    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }


}
package com.example.kotlin.study.net

import android.content.Context
import android.util.Log
import com.example.kotlin.study.config.Flag.TAG
import com.example.kotlin.study.entity.LoginResponseWarpper
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import okhttp3.Dispatcher

/**
 * Created by liuml on 2021/5/5 20:00
 */
abstract class ApiResponse<T>(val context: Context) : Observer<LoginResponseWarpper<T>> {

    private var isShow: Boolean = true

    //次构造
    constructor(context: Context, isShow: Boolean = false) : this(context) {
        this.isShow = isShow
    }


    //返回成功结果
    abstract fun success(data: T?)

    //返回失败结果
    abstract fun failure(errorMsg: String?)


    //rxjava的操作

    //起点分发的时候

    override fun onSubscribe(d: Disposable) {
        if (isShow) {
            //弹出 加载框
            Log.d(TAG, "onSubscribe: 开始分发")
        }
    }


    // 上游流下了的数据
    override fun onNext(t: LoginResponseWarpper<T>) {

        if (t.data == null) {
            // 失败
            failure("登录失败了，请检查原因：msg:${t.errorMsg}")
        } else {
            // 成功
            success(t.data)
        }
    }

    // 上游流下了的错误
    override fun onError(e: Throwable) {
        // 取消加载
//        LoadingDialog.cancel()

        failure(e.message)
    }

    // 停止
    override fun onComplete() {
        // 取消加载
//        LoadingDialog.cancel()
    }

}

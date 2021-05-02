package com.example.kotlin.study.test.classdemo2

import android.util.Log

/**
 * @explain kotlin 单例模式 例子1  模仿java 静态内部类单例
 * @author liuml
 * @time  2021/5/2 17:41
 */
class NetEngine {

    //使用object
    object Holder {
        var instance = NetEngine()
    }

    //应该写一个获取的方法, kotlin里面 没有static 用 companion object 派生代替  就是说当NetEngine这个类创建的时候 companion object里面也同时创建了
    companion object {
        fun getInstnce(): NetEngine = Holder.instance
    }

    fun show() {
        Log.d("NetEngine","NetEngine 单例 展示 show ")
    }
}
package com.example.kotlin.study.test.classdemo2

import android.util.Log

/**
 * @explain
 * @author liuml
 * @time  2021/5/2 17:14
 */
object MyEngine {
    fun m(){
        Log.d("MyEngine","执行 m ")
    }
    fun show(){
        Log.d("MyEngine","只有一个实例 ")
    }
}
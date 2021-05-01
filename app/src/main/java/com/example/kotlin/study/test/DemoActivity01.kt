package com.example.kotlin.study.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlin.study.R

/**
 * 1. var val 使用
 * 2. 方法的使用
 *
 */
class DemoActivity01 : AppCompatActivity() {
    var TAG = "DemoActivity01"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo01)

        //   var是一个可变变量，这是一个可以通过重新分配来更改为另一个值的变量。这种声明变量的方式和java中声明变量的方式一样。
        //   val是一个只读变量，这种声明变量的方式相当于java中的final变量。一个val创建的时候必须初始化，因为以后不能被改变。
        var sumResult = 0
//        sumResult = "aa" //因为是静态语言 定义了就不能再改了
        val testV = '1'
//        testV = 1;//这里会报错

        //2. 返回值
        var resume = add(1, 2)
        Log.d(TAG, "onCreate: " + resume)
    }


    /**
     * 函数返回值类型在冒号后面.
     * 基本类型和java的区别是 前面的字母变成大写.
     * 参数定义放在后面 和java 刚好相反
     * 这个方法返回两数之和
     */
    fun add(numbe1: Int, number2: Int): Int {
        return numbe1 + number2
    }
}
package com.example.kotlin.study.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.study.R

/**
 * 条件控住
 */
class Demo03Activity : AppCompatActivity() {
    val TAG = "Demo03Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo03)

        demo01()
        demo02()
    }

    private fun demo02() {
        //when 语句对应java 的 switch
        var number = 5
        when (number) {
            1 ->   Log.d(TAG, "当前一")
            2 ->   Log.d(TAG, "当前二")
            3 ->   Log.d(TAG, "当前三")
            4 ->   Log.d(TAG, "当前四")
            5 ->   Log.d(TAG, "当前五")
            else -> Log.d(TAG, "其他数值")
        }
        //使用in 关键字
        var number2 = 500
        when (number2) {
            in 1..200 ->   Log.d(TAG, "当前区间1..200")
            in 200..300 ->   Log.d(TAG, "当前区间200..300")
            in 300..500 ->   Log.d(TAG, "当前区间300..500")
            else -> Log.d(TAG, "其他数值")
        }
    }

    fun demo01() {
        var number1 = 9999;
        var number2 = 8888;

        //条件表达式比较大小
        var maxNumber = if (number1 > number2) number1 else number2
        Log.d(TAG, "条件表达式比较大小 : ${maxNumber}")

        //第二种 表达式里面做点操作后再返回
        val max: Int = if (number1 > number2) {
            Log.d(TAG, "表达式判断number1 之前可以做一些操作: ${number1}")
            number1
        } else {
            Log.d(TAG, "表达式判断number2 之前可以做一些操作: ${number1}")
            number2
        }
        Log.d(TAG, "表达式判断之前做操作后判断大小 ${max}")
    }
}

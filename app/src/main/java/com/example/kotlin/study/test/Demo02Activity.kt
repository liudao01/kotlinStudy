package com.example.kotlin.study.test

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.study.R

/**
 *  2.比较和数组
 */
class Demo02Activity : AppCompatActivity() {
    val TAG = "Demo02Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo02)

        demo1()

        demo2()
    }

    private fun demo2() {
        //数组
        var number = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        for (i in number) {
            Log.d(TAG, "打印数组 : ${i}")
        }

        //第二种方式 定义数组有20个   value是Int类型   value默认从第0个开始  并且每个value加上1000 20次
        var number2 = Array(20, { value: Int -> ( value + 1000 ) })

        for (n in number2) {
            Log.d(TAG, "打印数组第二种 : ${n}")
        }
    }

    private fun demo1() {
        //比较
        val name1 = "name1"
        val name2 = "name1"

        //比较两个值本身
        Log.d(TAG, "使用等号比较对象值本身 : ${name1 == name2}")
        Toast.makeText(this, "使用等号比较对象值本身 : ${name1 == name2}", Toast.LENGTH_SHORT).show()

        //

        //比较对象地址
        val number1: Int? = 1000
        val number2: Int? = 1000
//        Log.d(TAG, "使用三等号比较对象引用地址: ${number1 === number2}")
    }
}
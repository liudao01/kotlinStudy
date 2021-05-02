package com.example.kotlin.study.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.study.R

/**
 * 循环和标签
 */
class Demo04Activity : AppCompatActivity() {
    var TAG = "Demo04Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo04)

        demo01()
        demo02()
    }

    //标签
    private fun demo01() {

        //自定义标签
        test@ for (i in 1..10) {
            for (j in 1..10) {
                Log.d(TAG, "外层循环 $i,内层循环$j")
                if (i == 2) {
                    //通过break标签 将外层循环全部break
                    break@test
                }
            }
        }

    }

    //循环
    private fun demo02() {

        var items = listOf("aaa", "bbb", "ccc")
        for (s in items) {
            Log.d(TAG, "普通循环 $s")
        }

        items.forEach {
            Log.d(TAG, "foreach it 循环 $it")
        }

        for (index in items.indices) {
            Log.d(TAG, "items.indices 循环 下标 $index  值 ${items[index]}")

        }


    }
}
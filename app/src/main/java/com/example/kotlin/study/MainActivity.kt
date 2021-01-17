package com.example.kotlin.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    //   var是一个可变变量，这是一个可以通过重新分配来更改为另一个值的变量。这种声明变量的方式和java中声明变量的方式一样。
    //   val是一个只读变量，这种声明变量的方式相当于java中的final变量。一个val创建的时候必须初始化，因为以后不能被改变。

    var sumResult = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "sumResult =  " + sumResult)
        //demo1
        sumResult = sumDemo(1, 2)
        Log.d("MainActivity", "计算结果 =  " + sumResult)

        //demo2 检测是否是大于10
        var isTen = checkNumber(10)
        Log.d("MainActivity", "计算结果数据是否等于10 =  " + isTen)

        //demo3 返回一个字符串
        var myStr = syHello("liudao")
        Log.d("MainActivity", "返回的字符串 =  " + myStr)

        //demo4 模板字符串
        var myStr2 = testString("name")
        Log.d("MainActivity", "拼接的字符串 =  " + myStr2)

        //demo5 空值处理
        Log.d("MainActivity", "非空值处理 =  " + heat("水"))
        Log.d("MainActivity", "空值处理 =  " + heat(null))

        //demo6 循环 区间(高斯的那个故事 哈哈 从1加到100)
        var nums = 1..100//这个是
        Log.d("MainActivity", "从1加到100  =  " + loopFun(nums))
        //demo6 循环 区间(步长使用)
        var stepNum = 1..16//这个是
        loopSetpFun(stepNum)

        //demo7 list 和map 使用
        useList();


        //demo5 可变长参数函数
    }

    private fun useList() {
        var lists = listOf("one", "two", "three", "four", "five")
        for (item in lists) {
            Log.d("MainActivity", "遍历list  =  " +item)
        }
    }


    /**
     * 稍微解释下 IntRange 是int 类型的区间
     */
    private fun loopFun(nums: IntRange): Int {
        var result = 0;
        for (num in nums) {
            result = result + num
        }

        return result
    }

    /**
     * 区间步长使用
     */
    private fun loopSetpFun(nums: IntRange) {
        for (num in nums step 2) {
            Log.d("MainActivity", "区间使用步长  =  " + num)
        }
    }


    /**
     * 加上问号代表参数可以为空
     */
    fun heat(str: String?): String {
        return "热" + str

    }

    fun testString(name: String): String {
        //模板字符串拼接
        return "拼接的字符串是${name}"
    }


    fun syHello(str: String): String {
        return "hello " + str;
    }

    private fun checkNumber(i: Int): Boolean {
        return i == 10;
    }

    /**
     * 两数相加返回结果
     */
    fun sumDemo(i: Int, j: Int): Int {
        return i + j
    }


}
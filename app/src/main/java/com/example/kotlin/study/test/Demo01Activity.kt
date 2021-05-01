package com.example.kotlin.study.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.study.R

/**
 * 基础语法
 * 1. var val 使用
 * 2. 函数的使用 - kotlin 可以把函数写在 类的外面 (为什么叫做函数)
 *
 */
class Demo01Activity : AppCompatActivity() {
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


        //3.vararg 可变长度和for循环
        lenMethod(1, 2, 3, 4, 5, 6, 7)

        //4 lambda 表达式函数 第一个箭头后面的Int  number1, number2 是参数
        var addMethod: (Int, Int) -> Int = { number1, number2 -> number1 + number2 }

        var addresult = addMethod(9, 8)
        Log.d(TAG, "onCreate: " + addresult)

        //5 字符串模板
        var name = "name"
        var age = 18
        var info = "asdfasdf"

        Log.d(TAG, "字符串模板: name = $name  age = $age  info = $info")

        //换行自己使用三个引号
        var infoManager = """
            第一行111111
            第二行222222
            第三行3333333
            第四行44444444
        """.trimIndent()
        Log.d(TAG, "字符串模板: infoManager = $infoManager")

        //需求显示$99.99
        var price = """
            ${'$'}99.99
        """.trimIndent()
        Log.d(TAG, "字符串模板 显示美元符:  = $price")

        //6 NULL 检查机制

        var infoNull: String? = null
        Log.d(TAG, "空指针检查机制:  = ${infoNull?.length}")// 第一种 最常用: ? 如果infoNull 是null 就不执行.length

//        Log.d(TAG, "空指针检查机制:  = ${infoNull!!.length}")// 第二种 慎用  :!! (和java作用一眼个): ? 如果infoNull 是null 就不执行.length

        Log.d(
            TAG,
            "空指针方法返回:  第一次参数为liu = ${testMethod("liu")}  第二个次参数空 ${testMethod("")}"
        )// 第一种 最常用: ? 如果infoNull 是null 就不执行.length

        //7 区间
        demo7()

    }

    fun demo7() {
        for (i in 1..9) {
            Log.d(TAG, "输出区间 ${i}")// 区间
        }
        //反向输出使用
        for (i in 9 downTo 1) {
            Log.d(TAG, "输出区间使用downTo  ${i}")// 区间
        }
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

    /**
     * 第二种写法,未定义返回值类型也可自行推断  使用等号
     */
    fun add2(numbe1: Int, number2: Int) = numbe1 + number2


    /**
     * 打印可变长度 和for循环 使用In
     */
    fun lenMethod(vararg value: Int) {
        for (i in value) {
            Log.d(TAG, "lenMethod: " + i)
        }
    }

    //:Int? 加上问号允许返回null
    fun testMethod(name: String): Int? {
        if (name == "liu") {
            return 1000;
        }
        return null;
    }
}
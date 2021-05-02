package com.example.kotlin.study.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.study.R
import com.example.kotlin.study.test.classdemo2.MyEngine
import com.example.kotlin.study.test.classdemo2.NetEngine
import com.example.kotlin.study.test.classdemo2.User

/**
 * 类与对象
 */
class Demo05Activity : AppCompatActivity() {
    var TAG = "Demo05Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo05)

//        kotlin中 类与对象 和java是不一样的
        var person = Person() //调用次构造 次构造传参给主构造默认的值

        person = Person(111)//调用主构造


        //使用数据类型
        var user = User("liu", 18, '1')
        Log.d(TAG, "打印用户信息 $user")

        var (myNmae, myAge, mySex) = user.copy()
        Log.d(TAG, "打印用户拷贝信息 myNmae: $myNmae ,myAge: $myAge ,mySex: $mySex")

        var (myname1, _, _) = user.copy()
        Log.d(TAG, "打印用户拷贝信息  myname1: $myname1 其他用下划线拒收")

        //单例使用object  不会多次创建
        MyEngine.m()
        MyEngine.m()
        MyEngine.m()

        //自己创建一个单例
        var instance = NetEngine.getInstnce()
        instance.show()
    }
}

//人这个类
open class Person(id: Int) {//id : Int  是主构造

    //次构造  次构造必须调用主构造  this(id)
    constructor(id: Int, name: String) : this(id) {

    }

    //次构造
    constructor(id: Int, sex: Char) : this(id) {

    }

    //次构造
    constructor() : this(0) {

    }
}

//继承 和实现 全部使用冒号  被继承的类需要加上open

class Student(id: Int) : Person(id) {

    //kotlin中全部没有默认值, java中成员有默认值,但是方法内部没有默认值

    //class Student : Person() {
    //lateinit 是懒加载 先不加载  没有赋值 就不能使用
    lateinit var name: String

    var age: Int = 0
}

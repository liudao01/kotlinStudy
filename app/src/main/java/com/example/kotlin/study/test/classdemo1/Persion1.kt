package com.example.kotlin.study.test.classdemo1

/**
 * @explain
 * @author liuml
 * @time  2021/5/2 16:35
 */

//默认 public  final class Persion1 是不能被继承的   abstract关键字修饰就可以被继承 相当于open
//Persion1 实现 CallBack  多个接口用逗号区分
abstract class Persion1 : CallBack ,CallBack2{

    abstract fun getLayoutId(): Int
    abstract fun initView()

}
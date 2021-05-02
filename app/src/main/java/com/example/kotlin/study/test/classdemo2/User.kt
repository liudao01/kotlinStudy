package com.example.kotlin.study.test.classdemo2

/**
 * @explain
 * @author liuml
 * @time  2021/5/2 16:59
 */
//数据类型 data 的使用类似于javaBean  并且还提供了 eques  copy等函数
data class User(
    var name: String,
    var age: Int,
    var sex: Char
)
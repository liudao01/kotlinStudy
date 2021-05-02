package com.example.kotlin.study.test.classdemo1

/**
 * @explain
 * @author liuml
 * @time  2021/5/2 16:36
 */
class Studen1 : Persion1() {
    override fun getLayoutId(): Int = 1

    override fun initView() {
    }

    override fun callBackMethod(): Boolean {
       return true
    }

}
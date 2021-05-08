package com.example.kotlin.study

import android.app.Application
import com.example.kotlin.study.database.StudentDatabase

/**
 * Created by liuml on 2021/5/7 13:31
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // 初始化
        StudentDatabase.getDatabase(this)
    }
}
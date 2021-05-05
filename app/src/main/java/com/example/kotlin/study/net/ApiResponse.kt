package com.example.kotlin.study.net

import android.content.Context
import com.example.kotlin.study.entity.LoginResponseWarpper
import io.reactivex.Observable

/**
 * Created by liuml on 2021/5/5 20:00
 */
abstract class ApiResponse<T> (val context: Context)
    :Observable<LoginResponseWarpper<T>>{

    }
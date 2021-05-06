package com.example.kotlin.study.api

import com.example.kotlin.study.entity.LoginRegisterResponse
import com.example.kotlin.study.entity.LoginRegisterResponseWarpper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @explain
 * @author liuml
 * @time  2021/5/3 18:05
 */
interface WanAndroidApi {


    @POST("/user/login")
    @FormUrlEncoded
    fun loginAciton(
        @Field("username") username: String, @Field("password") password: String
    )
            : Observable<LoginRegisterResponseWarpper<LoginRegisterResponse>>

}
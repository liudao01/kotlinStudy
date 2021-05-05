package com.example.kotlin.study.net

import com.example.kotlin.study.config.Flag
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by liuml on 2021/5/5 16:59
 */
class APIClent {

    //单例

    private object Holder{
        val INSTANCE = APIClent()
    }

    //派生
    companion object {
        val instance = Holder.INSTANCE;
    }


    fun <T> instanceRetrofit(apiIntface:Class<T> ): T{

        val mOkHttpClient = OkHttpClient().newBuilder()
                //读取时间
            .readTimeout(10000, TimeUnit.SECONDS)
            //链接超时时间
            .connectTimeout(10000, TimeUnit.SECONDS)
                //写出超时时间
            .writeTimeout(10000, TimeUnit.SECONDS)
            .build()

        //初始化retriofit
        var mRetrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Flag.BASE_URL1)
            .client(mOkHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return mRetrofit.create(apiIntface)

    }
}
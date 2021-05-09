package com.example.kotlin.study.data_model.request

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.example.kotlin.study.config.Flag
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

// 被继承的资格
abstract class NetworkResultData : Callback {
    override fun onFailure(call: Call, e: IOException) {
        Log.e(Flag.TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>> onFailure: use okhttp network request TO Exception: ${e.message}" );
        // requestError("请求时发送了异常，请开发者来 com.xiangxue.googleproject.data.repository.request.ICallback 寻找错误详情原因!!")

        // 在主线程 执行
        Handler(Looper.getMainLooper(), Handler.Callback {
            // 如果message不为null，就执行 .let { requestError(it)  }   it==message本身
            e.message?.myLet { requestError(this)  }
            false // 正常执行下去 false
        }).sendEmptyMessage(0)
    }

    override fun onResponse(call: Call, response: Response) {
        // 在主线程 执行
        Handler(Looper.getMainLooper(), Handler.Callback {
            reqeustSuccess(response)
            false  // 正常执行下去 false
        }).sendEmptyMessage(0)
    }

    // 封装后的 失败
    abstract fun requestError(info: String)

    // 封装后的 成功
    abstract fun reqeustSuccess(result: Response)


    //高阶函数
    fun <T, R> T.myLet(mm: T.(T) -> R): R {
        // T == this
        // mm(this) == this
        return mm(this)
    }
}
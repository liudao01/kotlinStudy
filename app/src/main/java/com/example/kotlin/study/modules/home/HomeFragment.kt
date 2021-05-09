package com.example.kotlin.study.modules.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.kotlin.study.R
import com.example.kotlin.study.adapter.HomeInfoListAdapter
import com.example.kotlin.study.config.Flag
import com.example.kotlin.study.data_model.request.NetworkResultData
import com.example.kotlin.study.data_model.request.RequestAPI
import com.example.kotlin.study.entity.HomeDataResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    val TAG = "HomeFragment"

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated: ")
        requestHomeData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")

    }
    private lateinit var linkPath1: String
    private lateinit var linkPath2: String
    fun requestHomeData() {
        RequestAPI.instanceRequestAction(Flag.SERVER_URL, "1", object : NetworkResultData() {
            override fun requestError(info: String) {
                showResultError(info)
            }

            override fun reqeustSuccess(result: Response) {
                try {
                    val resultData = result.body()?.string().toString()
                    Log.e(Flag.TAG,
                        "成功  数据在response里面  获取后台给我们的JSON 字符串 resultData:$resultData")

                    // Gson解析成可操作的对象
                    val gson = Gson()
                    val homeDataResponse: HomeDataResponse = gson.fromJson(resultData, HomeDataResponse::class.java)
                    // home_listview.adapter = HomeInfoListAdapter(context!!, result.data.news_list)
                    home_listview.adapter =
                        context?.myRun { HomeInfoListAdapter(it, homeDataResponse.data.news_list) }

                    // 两者图片的显示
                    Glide.with(iv_top).load(homeDataResponse.data.company_list[0].image).into(iv_top)
                    Glide.with(iv_bottom).load(homeDataResponse.data.ad_list[0].image).into(iv_bottom)

                    // WebView需要加载的URL 链接  两个 两张图片
                    linkPath1 = homeDataResponse.data.company_list[0].link
                    linkPath2 = homeDataResponse.data.ad_list[0].link
                }catch (e: Exception) {
                    e.printStackTrace()

                    Log.e(Flag.TAG, "requestSuccess 解析数据时Exception:${e.message}")
                }

            }
        })
    }

    /**
     * TODO 首页的画面展示【失败】
     */
    private fun showResultError(errorMsg: String) {
        Log.d(TAG, "showResultError: ${String} ")
        Toast.makeText(activity, "首页数据请求失败: errorMsg:$errorMsg", Toast.LENGTH_SHORT).show()
    }
}

fun <T, R> T.myRun(m: (T) -> R): R = m(this)
package com.example.kotlin.study.modules.collect

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.study.R
import com.example.kotlin.study.adapter.CollectAdapter
import com.example.kotlin.study.config.Flag
import com.example.kotlin.study.data_model.local.LocalRoomRequestManager
import com.example.kotlin.study.database.Student
import kotlinx.android.synthetic.main.fragment_collect.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [collectFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class collectFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val TAG = "collectFragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

     var adapter :CollectAdapter   = CollectAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collect, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //获取数据刷新
        recyclerView.layoutManager = LinearLayoutManager(activity)

        updateData()
        //　TODO Insert　动作
        addData.setOnClickListener {
            val names = arrayOf<String>(
                "乔峰",
                "段誉",
                "虚竹",
                "慕容复",
                "张三",
                "李四",
                "王五",
                "赵六",
                "初七",
                "杜子腾",
                "王小二",
                "李大奇"
            )
            val ages = arrayOf<Int>(
                43,
                24,
                19,
                83,
                64,
                21,
                56,
                32,
                17,
                32,
                45,
                14
            )
            for (index in names.indices) {
                val stu = Student(names[index], ages[index])
                requestInsert(stu)
            }

            //查询
            updateData()

        }

        //全部删除
        clearData.setOnClickListener {
            requestDeleteAll()
            updateData()
        }
    }

    //查询并更新
    fun updateData() {
        var list = requestQueryAll()
        Log.d(TAG, "onViewCreated: ${list}")
        if (null != list) {
            adapter.allStudents = list
            //其实这里应该是更新操作 我这图省事直接赋值adapter了
            recyclerView.adapter = adapter
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment collectFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            collectFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


//-----------不写mvp了  前面登录注册写过了----------

    fun requestInsert(
        vararg students: Student
    ) {
        LocalRoomRequestManager.getInstance().insertStudents(*students)
        // TODO 伪代码：例如：这里还可以做很多的逻辑，等等，最终确保此操作没有问题，就返回true
        //  ......
    }

    fun requestUpdate(
        vararg students: Student
    ) {
        LocalRoomRequestManager.getInstance().updateStudents(*students)
        // TODO 伪代码：例如：这里还可以做很多的逻辑，等等，最终确保此操作没有问题，就返回true
        //  ......
    }

    fun requestDelete(
        vararg students: Student
    ) {
        LocalRoomRequestManager.getInstance().deleteStudents(*students)
        // TODO 伪代码：例如：这里还可以做很多的逻辑，等等，最终确保此操作没有问题，就返回true
        //  ......
    }

    fun requestDeleteAll() {
        LocalRoomRequestManager.getInstance().deleteAllStudent()
        // TODO 伪代码：例如：这里还可以做很多的逻辑，等等，最终确保此操作没有问题，就返回true
        //  ......
    }

    fun requestQueryAll() : List<Student>? {
        val result = LocalRoomRequestManager.getInstance().queryAllStudent()
        Log.d(Flag.TAG, "requestQueryAll: result$result")
       return  result
    }
}
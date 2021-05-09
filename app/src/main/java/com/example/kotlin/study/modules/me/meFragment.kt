package com.example.kotlin.study.modules.me

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.kotlin.study.R
import kotlinx.android.synthetic.main.fragment_me.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [meFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class meFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_me, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment meFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            meFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webview_me.loadUrl("https://www.liuml.co")

        webview_me.getSettings().setJavaScriptEnabled(true)
        webview_me.getSettings().setSupportZoom(true)
        webview_me.getSettings().setBuiltInZoomControls(true)
        webview_me.setWebChromeClient(WebViewClient())
        webview_me.setWebViewClient(android.webkit.WebViewClient()) //防止用浏览器打开网页


    }

   inner class WebViewClient: WebChromeClient() {

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            pb?.setVisibility( View.VISIBLE)
            pb?.setProgress(newProgress);
            if(newProgress>=99){
                pb?.setVisibility(View.GONE);
            }
            super.onProgressChanged(view, newProgress)
        }


    }
}
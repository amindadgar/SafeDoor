package com.example.sampleapp.Ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.sampleapp.R
import okhttp3.*
import java.io.IOException



class second_fragment : Fragment() {
    lateinit var okHttpClient:OkHttpClient
    lateinit var TextView:TextView
    lateinit var callRequest:Call
    lateinit var button: Button
    lateinit var progressBar: ProgressBar

    companion object {

        @JvmStatic
        fun newInstance():second_fragment {
            val secondFragment = second_fragment()

            return secondFragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        okHttpClient = OkHttpClient().newBuilder()
            .retryOnConnectionFailure(true)
            .build()

        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        TextView = view!!.findViewById(R.id.second_fragment_text)
        button = view!!.findViewById(R.id.retryB_secondFragment)
        progressBar = view!!.findViewById(R.id.progressBar)
        progressBar.visibility = View.INVISIBLE





        val request = Request.Builder()
            .url("http://192.168.1.6")
            .build()
        button.setOnClickListener {
            progressBar.visibility = View.VISIBLE


            callRequest = okHttpClient.newCall(request)
            callRequest.enqueue(object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    TextView.text = response.body!!.string()
                    progressBar.visibility = View.INVISIBLE
                }

                override fun onFailure(call: Call, e: IOException) {
                    TextView.text = e.printStackTrace().toString()
                    call.cancel()
                    progressBar.visibility = View.INVISIBLE
                }


            })
        }
    }





}

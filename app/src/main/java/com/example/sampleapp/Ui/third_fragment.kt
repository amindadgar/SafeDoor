package com.example.sampleapp.Ui


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.sampleapp.MapsActivity
import com.example.sampleapp.R


class third_fragment : Fragment() {

    companion object {


        @JvmStatic
        fun newInstance() : third_fragment {
            val thirdFragment = third_fragment()
            return thirdFragment
        }
    }
    lateinit var textView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onStart() {
        super.onStart()
        textView = view!!.findViewById(R.id.third_fragment_text)
        button = view!!.findViewById(R.id.third_fragment_button)

        button.setOnClickListener {
            startActivity(Intent(context,MapsActivity::class.java))
        }

    }



}

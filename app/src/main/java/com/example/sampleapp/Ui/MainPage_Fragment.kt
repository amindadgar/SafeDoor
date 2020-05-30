package com.example.sampleapp.Ui

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.Adapters.MainRecyclerAdapter
import com.example.sampleapp.Model.MainPageViewModel
import com.example.sampleapp.Model.Users

import com.example.sampleapp.R

class MainPage_Fragment : Fragment() {

    companion object {
        fun newInstance(users:Users,position:Int) : MainPage_Fragment{
            val args = Bundle()

            args.putInt("position",position)
            args.putString("Name",users.Name)
            args.putString("Age",users.Age.toString())
            args.putString("Id",users.id.toString())
            val mainpageFragment = MainPage_Fragment()
            mainpageFragment.arguments = args
            return mainpageFragment
        }
    }

    private lateinit var viewModel: MainPageViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_page_fragment, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        // TODO: Use the ViewModel

        val textview = view!!.findViewById<TextView>(R.id.TextView)
        val position = arguments!!.getInt("position")
        val Name = arguments!!.getString("Name")
        val Age = arguments!!.getString("Age")



        when (position){
            0 ->  Home()
        }


        textview.text = "Name: ${Name}\nAge: ${Age}"


    }
    fun Home(){
        viewModel = ViewModelProviders.of(this).get(MainPageViewModel::class.java)

        recyclerView = view!!.findViewById(R.id.MainRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MainRecyclerAdapter(listOf(Users("Ali",25,1),
            Users("Ziba",23,2),
            Users("Sarah",20,3)))

        viewModel.Data.observe(this, Observer {

        })
    }
}

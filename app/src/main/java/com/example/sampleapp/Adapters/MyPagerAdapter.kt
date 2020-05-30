package com.example.sampleapp.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.sampleapp.Model.Users
import com.example.sampleapp.Ui.MainPage_Fragment
import com.example.sampleapp.Ui.second_fragment
import com.example.sampleapp.Ui.third_fragment

class MyPagerAdapter (fragmentManager: FragmentManager,private val DataArray:List<Users>)
    :FragmentPagerAdapter(fragmentManager){


    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MainPage_Fragment.newInstance(DataArray[position],position)
            1 -> second_fragment.newInstance()
            2 -> third_fragment.newInstance()
            else -> MainPage_Fragment.newInstance(DataArray[position],position)
        }
    }

    override fun getCount(): Int {
        return  DataArray.size
    }



    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Home"
            1 -> "Liked"
            2 -> "History"
            else -> "Unkown"
        }
    }




}
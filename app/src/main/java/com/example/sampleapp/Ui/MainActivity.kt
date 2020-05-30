package com.example.sampleapp.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.sampleapp.Adapters.MyPagerAdapter
import com.example.sampleapp.Model.Users
import com.example.sampleapp.R
import com.gauravk.bubblenavigation.BubbleNavigationLinearView
import com.ogaclejapan.smarttablayout.SmartTabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewpager:ViewPager
    lateinit var myPagerAdapter: MyPagerAdapter
    lateinit var BottomNavigation:BubbleNavigationLinearView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BottomNavigation = findViewById(R.id.navigationBar)

        viewpager = findViewById(R.id.ViewPager)
        myPagerAdapter = MyPagerAdapter(supportFragmentManager,
            listOf(
                Users("Ali",25,1),
                Users("Ziba",23,2),
                Users("Sarah",20,3)))

        viewpager.adapter = myPagerAdapter
        Toast.makeText(this,viewpager.currentItem.toString(),Toast.LENGTH_LONG).show()
        viewPagerListener(viewpager)
        BottomNavigation.setBadgeValue(0,"2")

    }

    fun viewPagerListener(viewPager: ViewPager){
            viewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
                override fun onPageScrollStateChanged(state: Int) {
                   Log.d("PageScrollState Changed","$state")
                }

                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    Log.d("onPageScrolled",position.toString())
                }

                override fun onPageSelected(position: Int) {
                    BottomNavigation.setCurrentActiveItem(position)
                }

            })
    }
}

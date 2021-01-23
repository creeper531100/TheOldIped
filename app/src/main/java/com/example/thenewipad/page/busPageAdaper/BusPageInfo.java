package com.example.thenewipad.page.busPageAdaper

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.thenewipad.R
import com.example.thenewipad.formatFolder.BusStopRoute
import com.example.thenewipad.function.JsonDataFormat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import java.util.*

class BusPageInfo : AppCompatActivity() {
    var viewPager: ViewPager? = null
    var contentArrary: Array<String>
    var tabLayout: TabLayout? = null
    var To = ArrayList<String>()
    var Back = ArrayList<String>()

    @RequiresApi(api = Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_page_info)
        val titleText = findViewById<TextView>(R.id.TitleText)
        val busHeaderText = findViewById<TextView>(R.id.BusHeaderText)
        tabLayout = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.view_pager)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "哈哈", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val intent = intent
        val getContent = intent.getStringExtra("title")
        contentArrary = getContent!!.split("\n".toRegex()).toTypedArray()
        val direction: Array<String?> = contentArrary[1].split("-".toRegex(), 2).toTypedArray()
        titleText.text = contentArrary[0]
        busHeaderText.text = contentArrary[1]
        val getJson = JsonDataFormat("https://ptx.transportdata.tw/MOTC/v2/Bus/StopOfRoute/City/Taichung/" //RealTimeNearStop, StopOfRoute, Route
                + contentArrary[0] + "?&\$format=JSON", BusStopRoute::class.java)
        getJson.request()
        val dataParsing = getJson.dataParsing()
        println(dataParsing)
        var i = 0
        while (i < dataParsing.size) {
            if (dataParsing[i + 1] == contentArrary[0]) {
                if (dataParsing[i] == "1") To.add(dataParsing[i + 2]) else Back.add(dataParsing[i + 2])
            } //else
            i += 3
        }
        val myPagerAdapter = MyPagerAdapter(supportFragmentManager, direction)
        tabLayout.setupWithViewPager(viewPager)
        viewPager.setAdapter(myPagerAdapter)
    }

    internal inner class MyPagerAdapter(fm: FragmentManager, var fragmentNames: Array<String?>) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return BusToPage(contentArrary[0], To)
                1 -> return BusBackPage(contentArrary[0], Back)
            }
            return null
        }

        override fun getCount(): Int {
            return fragmentNames.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return fragmentNames[position]
        }

    }
}
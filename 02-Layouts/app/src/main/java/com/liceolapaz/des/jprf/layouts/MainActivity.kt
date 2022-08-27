package com.liceolapaz.des.jprf.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Uncomment the one you want to use and comment the rest
        setContentView(R.layout.activity_main_framelayout)
//        setContentView(R.layout.activity_main_gridlayout)
//        setContentView(R.layout.activity_main_linearlayout)
//        setContentView(R.layout.activity_main_linearlayout_weight)
//        setContentView(R.layout.activity_main_relativelayout)
//        setContentView(R.layout.activity_main_tablelayout)
    }
}
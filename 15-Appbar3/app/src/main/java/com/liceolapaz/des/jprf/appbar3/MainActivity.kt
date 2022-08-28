package com.liceolapaz.des.jprf.appbar3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    private lateinit var cmbToolbar : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tbar = findViewById<Toolbar>(R.id.appbar)
        setSupportActionBar(tbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        cmbToolbar = findViewById(R.id.cmbToolbar)
        val datos = arrayOf("Opción 1", "Opción 2", "Opción 3")
        val adaptador =
            ArrayAdapter(this, R.layout.appbar_filter_title, datos)
        adaptador.setDropDownViewResource(
            R.layout.appbar_filter_list)
        cmbToolbar.adapter = adaptador
        cmbToolbar.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>) {
                //... Acciones al no existir ningún elemento seleccionado
                Log.i("Appbar 3", "Ninuna opción seleccionada");
            }
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                //... Acciones al seleccionar una opción de la lista
                Log.i("Appbar 3", "Seleccionada opción $position")
            }
        }

        //Tabs + ViewPager
        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager2
        val miFragmentStateAdapter = MiFragmentStateAdapter(this)
        viewPager.adapter = miFragmentStateAdapter

        val tabLayout = findViewById<View>(R.id.appbartabs) as TabLayout
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        TabLayoutMediator(
            tabLayout, viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = miFragmentStateAdapter.getTabTitle(position)
        }.attach()
    }
}
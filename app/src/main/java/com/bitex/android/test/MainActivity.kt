package com.bitex.android.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitex.android.test.view.futures.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val tabTitles = listOf("Exchange", "Margin", "Futures")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.selectedItemId = R.id.page_3

        pager.adapter = ViewPagerFragmentAdapter(this)

        TabLayoutMediator(tab_layout, pager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

}
package com.csibtn.smusicplayer.ui.main.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.csibtn.smusicplayer.databinding.ActivityMainBinding
import com.csibtn.smusicplayer.ui.base.view.BaseMVPView

class MainActivity : AppCompatActivity(), BaseMVPView {
    private lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

    override fun switchOffTheMenu() {
        mainBinding.bottomNavBar.visibility = View.GONE
    }

    override fun switchOnTheMenu() {
        mainBinding.bottomNavBar.visibility = View.VISIBLE
    }
}
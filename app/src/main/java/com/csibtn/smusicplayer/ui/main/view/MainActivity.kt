package com.csibtn.smusicplayer.ui.main.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.csibtn.smusicplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

    fun switchOffTheMenu() {
        mainBinding.bottomNavBar.visibility = View.GONE
    }

    fun switchOnTheMenu() {
        mainBinding.bottomNavBar.visibility = View.VISIBLE
    }
}
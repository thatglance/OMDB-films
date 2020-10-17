package com.example.omdbfilms.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.omdbfilms.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container,
            SearchFragment()
        ).commit()
    }
}
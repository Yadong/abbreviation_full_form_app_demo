package com.abbreviationdemo.uis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abbreviationdemo.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, HomeFragment.newInstance())
                .commit()
        }
    }
}

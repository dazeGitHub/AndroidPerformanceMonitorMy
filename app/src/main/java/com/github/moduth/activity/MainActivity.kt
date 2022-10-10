package com.github.moduth.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.github.moduth.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn_block).setOnClickListener{
            evilMethod()
        }
    }

    private fun evilMethod(){
        SystemClock.sleep(1000)
    }
}
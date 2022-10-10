package com.github.moduth.activity

import android.content.Intent
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

        findViewById<View>(R.id.btn_print_thread_log).setOnClickListener {
            this.startActivity(Intent(this, PrintThreadMsgActivity::class.java))
        }

        findViewById<View>(R.id.btn_test_trace_view).setOnClickListener{
            this.startActivity(Intent(this, TraceViewActivity::class.java))
        }
    }

    private fun evilMethod(){
        SystemClock.sleep(5000)
    }
}
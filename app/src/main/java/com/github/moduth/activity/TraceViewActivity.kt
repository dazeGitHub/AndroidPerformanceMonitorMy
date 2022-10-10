package com.github.moduth.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.os.Trace
import androidx.recyclerview.widget.RecyclerView
import com.github.moduth.R

/**
 * 使用 TraceView 查看所有方法耗时
 */
class TraceViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Debug.startMethodTracing("onCreate")
        Trace.beginSection("onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trace_view)
        //Debug.stopMethodTracing() //通过这样的方式可以生成 .trace 文件
        Trace.endSection();
    }
}
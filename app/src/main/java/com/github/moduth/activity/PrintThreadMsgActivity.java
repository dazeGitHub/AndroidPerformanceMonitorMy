package com.github.moduth.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.github.moduth.R;
import com.github.moduth.blockcanary.internal.BlockInfo;

public class PrintThreadMsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_thread_msg);

        findViewById(R.id.btn_evil_method).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                evilMethod(v);
            }
        });

        //获取当前线程堆栈信息
        StringBuilder stringBuilder = new StringBuilder();

        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            stringBuilder
                    .append(stackTraceElement.toString())
                    .append(BlockInfo.SEPARATOR);
        }
        Log.e("TAG", stringBuilder.toString());
    }

    /**
     * com.github.moduth E/TAG: dalvik.system.VMStack.getThreadStackTrace(Native Method)
     *     java.lang.Thread.getStackTrace(Thread.java:1736)
     *     com.github.moduth.activity.PrintThreadMsgActivity.onCreate(PrintThreadMsgActivity.java:19)
     *     android.app.Activity.performCreate(Activity.java:8146)
     *     android.app.Activity.performCreate(Activity.java:8130)
     *     android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1310)
     *     android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3689)
     *     android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3887)
     *     android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:85)
     *     android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:140)
     *     android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:100)
     *     android.app.ActivityThread$H.handleMessage(ActivityThread.java:2317)
     *     android.os.Handler.dispatchMessage(Handler.java:106)
     *     android.os.Looper.loop(Looper.java:263)
     *     android.app.ActivityThread.main(ActivityThread.java:8292)
     *     java.lang.reflect.Method.invoke(Native Method)
     *     com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:612)
     *     com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1006)
     */

    public void evilMethod(View view){
        long start = System.currentTimeMillis();
        a();
        b();
        c();
        long duration = System.currentTimeMillis() - start;
    }

    public void a() {
        SystemClock.sleep(780);
    }

    public void b() {
        SystemClock.sleep(21);
    }

    public void c() {
        SystemClock.sleep(200);
    }

}
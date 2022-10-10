package com.github.moduth;

import android.app.Application;
import android.os.Looper;
import android.util.Log;
import android.util.Printer;

import com.github.moduth.blockcanary.BlockCanary;
import com.github.moduth.blockcanary.BlockCanaryContext;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BlockCanary.install(this, new BlockCanaryContext()).start();
        //如果要使用 BlockCanary.install(), 这里就不要使用 testBlock() 了,
        //否则会将 BlockCanary 设置的 MessageLogging 替换掉, 导致运行后 BlockCanary 没效果
        //testBlock();
    }

    public void testBlock(){
        Looper.getMainLooper().setMessageLogging(new Printer(){
            boolean start = true;
            long startTime = 0;
            private final long mBlockMillis = 1000;

            @Override
            public void println(String x){
                if(start){
                    start = false;
                    startTime = System.currentTimeMillis();
                }else{
                    start = true;
                    long curBlockTime = System.currentTimeMillis() - startTime;
                    Log.e("Monitor", "dispatchMessage 耗时 :" + curBlockTime);
                    Log.e("Monitor", "是否卡顿 : " + (curBlockTime > mBlockMillis));
                    Logger.e("aaa");
                }
            }
        });
    }

    static class Logger {
        public static void e(String msg){
            StackTraceElement element = Thread.currentThread().getStackTrace()[3];
            Log.e(BuildConfig.VERSION_NAME,
                String.format(
                        " (%s:%s) %s",
                        element.getFileName(),
                        element.getLineNumber(),
                        msg
                )
            );
        }
    }
}

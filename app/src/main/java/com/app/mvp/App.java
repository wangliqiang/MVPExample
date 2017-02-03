package com.app.mvp;

import android.app.Application;
import android.util.Log;

import com.app.mvp.utils.FakeCrashLibrary;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.squareup.leakcanary.LeakCanary;

import java.util.logging.Level;

import timber.log.Timber;

/**
 * Created by 王立强 on 2016/10/9.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化Timber
         */
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
        /**
         * 初始化LeakCanary
         */
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        /**
         * 初始化OkGo
         */
        OkGo.init(this);
        try {
            //全局参数设置
            OkGo.getInstance()
                    //打开调试开关
                    .debug("OkGo", Level.SEVERE, true)
                    //设置超时时间，默认60秒
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)
                    //设置全局缓存，默认无缓存
                    .setCacheMode(CacheMode.NO_CACHE)
                    //设置全局缓存时间，默认永不过期
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * A tree which logs important information for crash reporting.
     */
    private static class CrashReportingTree extends Timber.Tree {
        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }

            FakeCrashLibrary.log(priority, tag, message);

            if (t != null) {
                if (priority == Log.ERROR) {
                    FakeCrashLibrary.logError(t);
                } else if (priority == Log.WARN) {
                    FakeCrashLibrary.logWarning(t);
                }
            }
        }
    }
}

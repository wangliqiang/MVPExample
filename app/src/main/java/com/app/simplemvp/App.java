package com.app.simplemvp;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by 王立强 on 2016/10/9.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        //初始化
        OkGo.init(this);

        try {
            //全局参数设置
            OkGo.getInstance()
                    //打开调试开关
                    .debug("error",true)
                    //如果使用默认的 60秒
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)
                    //可以全局统一设置缓存模式,默认是不使用缓存
                    .setCacheMode(CacheMode.NO_CACHE)
                    //可以全局统一设置缓存时间,默认永不过期
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

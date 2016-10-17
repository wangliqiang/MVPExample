package com.app.mvp;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by ����ǿ on 2016/10/9.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        //��ʼ��
        OkGo.init(this);

        try {
            //ȫ�ֲ�������
            OkGo.getInstance()
                    //�򿪵��Կ���
                    .debug("error",true)
                    //���ó�ʱʱ�䣬Ĭ��60��
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)
                    //����ȫ�ֻ��棬Ĭ���޻���
                    .setCacheMode(CacheMode.NO_CACHE)
                    //����ȫ�ֻ���ʱ�䣬Ĭ����������
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

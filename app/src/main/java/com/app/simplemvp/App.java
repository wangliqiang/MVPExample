package com.app.simplemvp;

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
                    //���ʹ��Ĭ�ϵ� 60��
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)
                    //����ȫ��ͳһ���û���ģʽ,Ĭ���ǲ�ʹ�û���
                    .setCacheMode(CacheMode.NO_CACHE)
                    //����ȫ��ͳһ���û���ʱ��,Ĭ����������
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

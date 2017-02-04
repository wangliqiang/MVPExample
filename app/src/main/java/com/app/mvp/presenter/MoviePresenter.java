package com.app.mvp.presenter;

import android.support.annotation.NonNull;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.app.mvp.api.ServerApi;
import com.app.mvp.base.RxPresenter;
import com.app.mvp.model.MovieInfo;
import com.app.mvp.presenter.contract.MovieContract;
import com.app.mvp.utils.Log;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import java.util.Date;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by wangliqiang on 2016/10/12.
 */

public class MoviePresenter extends RxPresenter implements MovieContract.Presenter {

    private MovieContract.View mView;
    private MovieInfo mMovieInfo;

    public MoviePresenter(@NonNull MovieContract.View view){
        mView = checkNotNull(view,"View is not null");
        mView.setPresenter(this);
    }


    @Override
    public void getMovieInfo(int start, int count) {
        Subscription subscription = OkGo.get(ServerApi.TOP250)
                .params("start", start)
                .params("count", count)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                    Log.e("开始：",new Date().getSeconds()+"");
                    if(mMovieInfo == null){
                        mView.showLoading();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Log.e("结束：",new Date().getSeconds()+"");
                    mView.dismissLoading();
                    mMovieInfo  = JSON.parseObject(s, MovieInfo.class);
                    mView.showMovieInfo(mMovieInfo);
                }, throwable -> {
                    mView.showError();
                    throwable.printStackTrace();
                });
        subscribe(subscription);
    }
}

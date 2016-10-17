package com.app.mvp.ui.activity.douban.movie;

import android.support.annotation.NonNull;

import com.alibaba.fastjson.JSON;
import com.app.mvp.api.ServerApi;
import com.app.mvp.model.MovieInfo;
import com.app.mvp.utils.Log;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by wangliqiang on 2016/10/12.
 */

public class MoviePresenter implements MovieContract.Presenter {

    private MovieContract.View mView;
    private MovieInfo mMovieInfo;
    @NonNull
    private CompositeSubscription mSubscriptions;

    public MoviePresenter(MovieContract.View view){
        mSubscriptions = new CompositeSubscription();
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
                    if(mMovieInfo == null){
                        mView.showLoading();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    mView.dismissLoading();
                    mMovieInfo  = JSON.parseObject(s, MovieInfo.class);
                    mView.showMovieInfo(mMovieInfo);
                }, throwable -> {
                    mView.showError();
                    throwable.printStackTrace();
                });
        mSubscriptions.add(subscription);
    }

    @Override
    public void subscribe() {
        Log.e("subscribe","subscribe");
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }
}

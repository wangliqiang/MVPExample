package com.app.mvp.ui.activity.douban.moviedetail;

import com.alibaba.fastjson.JSON;
import com.app.mvp.api.ServerApi;
import com.app.mvp.model.MovieDetailInfo;
import com.app.mvp.utils.Log;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by 王立强 on 2016/10/12.
 */

public class MovieDetailPresenter implements MovieDetailContract.Presenter{

    private MovieDetailContract.View mView;

    private CompositeSubscription mSubscriptions;

    public MovieDetailPresenter(MovieDetailContract.View view){
        mSubscriptions = new CompositeSubscription();
        mView = checkNotNull(view,"View is not null");
        mView.setPresenter(this);
    }


    @Override
    public void getMovieDetail(String id) {
        Subscription subscription = OkGo.get(ServerApi.MOVIEDETAIL + id)
                .getCall(StringConvert.create(), RxAdapter.<String>create())
                .doOnSubscribe(() -> {
                    mView.showLoading();
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    mView.dismissLoading();
                    MovieDetailInfo movieDetailInfo = JSON.parseObject(s, MovieDetailInfo.class);
                    mView.showMovieDetail(movieDetailInfo);
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

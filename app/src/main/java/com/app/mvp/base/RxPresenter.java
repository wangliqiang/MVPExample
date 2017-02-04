package com.app.mvp.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by 王立强 on 2016/10/29.
 */

public abstract class RxPresenter<T>{

    protected CompositeSubscription mCompositeSubscription;

    protected void subscribe(Subscription subscription){
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    protected void unsubscribe(){
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }
}

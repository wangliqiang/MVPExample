package com.app.mvp.base;

/**
 * Created by 王立强  on 2016/10/11.
 */

public interface BasePresenter<T> {

   void attachView(T view);

   void detachView();

}

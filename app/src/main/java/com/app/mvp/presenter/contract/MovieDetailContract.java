package com.app.mvp.presenter.contract;

import com.app.mvp.base.BasePresenter;
import com.app.mvp.base.BaseView;
import com.app.mvp.model.MovieDetailInfo;

/**
 * Created by wangliqiang on 2016/10/12.
 */

public interface MovieDetailContract {

    interface View extends BaseView<Presenter> {

        void showMovieDetail(MovieDetailInfo movieDetailInfo);

        void showLoading();

        void dismissLoading();

        void showError();
    }

    interface Presenter extends BasePresenter {
        void getMovieDetail(String id);
    }
}

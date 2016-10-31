package com.app.mvp.presenter.contract;

import com.app.mvp.base.BasePresenter;
import com.app.mvp.base.BaseView;
import com.app.mvp.model.MovieInfo;

/**
 * Created by 王立强 on 2016/10/12.
 */

public interface MovieContract {
    interface View extends BaseView<Presenter> {

        void showMovieInfo(MovieInfo movieInfo);

        void showLoading();

        void dismissLoading();

        void showError();
    }

    interface Presenter extends BasePresenter {
        void getMovieInfo(int start, int count);
    }
}

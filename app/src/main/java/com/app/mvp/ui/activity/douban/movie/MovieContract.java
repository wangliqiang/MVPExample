package com.app.mvp.ui.activity.douban.movie;

import com.app.mvp.base.BasePresenter;
import com.app.mvp.base.BaseView;
import com.app.mvp.model.MovieInfo;

/**
 * Created by 王立强 on 2016/10/12.
 */

public class MovieContract {
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

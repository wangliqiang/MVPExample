package com.app.simplemvp.ui.activity.douban.moviedetail;

import com.app.simplemvp.base.BasePresenter;
import com.app.simplemvp.base.BaseView;
import com.app.simplemvp.model.MovieDetailInfo;

/**
 * Created by Õı¡¢«ø on 2016/10/12.
 */

public class MovieDetailContract {

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

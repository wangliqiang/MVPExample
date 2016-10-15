package com.app.simplemvp.ui.activity.douban.movie;

import com.app.simplemvp.base.BasePresenter;
import com.app.simplemvp.base.BaseView;
import com.app.simplemvp.model.MovieInfo;

/**
 * Created by Õı¡¢«ø on 2016/10/12.
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

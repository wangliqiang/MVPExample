package com.app.simplemvp.ui.activity.douban.moviedetail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.app.simplemvp.R;
import com.app.simplemvp.base.BaseActivity;
import com.app.simplemvp.model.MovieDetailInfo;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.nineoldandroids.view.ViewHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

public class MovieDetailActivity extends BaseActivity implements MovieDetailContract.View, ObservableScrollViewCallbacks {

    Toolbar toolbar;

    @Bind(R.id.image)
    View mImageView;
    @Bind(R.id.toolbar)
    View mToolbarView;
    @Bind(R.id.scroll)
    ObservableScrollView mScrollView;

    @Bind(R.id.body)
    TextView body;

    private int mParallaxImageHeight;

    //电影ID
    String movieId;
    String movieName;


    private MovieDetailContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        new MovieDetailPresenter(this);

        movieId = this.getIntent().getStringExtra("movieId");
        movieName = this.getIntent().getStringExtra("movieName");


        toolbar = (Toolbar) mToolbarView;
        toolbar.setTitle(movieName);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.colorPrimary)));
        mScrollView.setScrollViewCallbacks(this);

        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.parallax_image_height);
        //加载数据
        mPresenter.getMovieDetail(movieId);
    }

    @Override
    public void showMovieDetail(MovieDetailInfo movieDetailInfo) {
        body.setText(movieDetailInfo.getSummary()+movieDetailInfo.getSummary()+movieDetailInfo.getSummary()+movieDetailInfo.getSummary());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void setPresenter(MovieDetailContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onScrollChanged(mScrollView.getCurrentScrollY(), false, false);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.colorPrimary);
        float alpha = Math.min(1, (float) scrollY / mParallaxImageHeight);
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha, baseColor));
        ViewHelper.setTranslationY(mImageView, scrollY / 2);
    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {

    }
}

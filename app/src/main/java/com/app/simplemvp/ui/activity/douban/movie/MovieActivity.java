package com.app.simplemvp.ui.activity.douban.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.app.simplemvp.R;
import com.app.simplemvp.base.BaseActivity;
import com.app.simplemvp.model.MovieInfo;
import com.app.simplemvp.ui.activity.douban.moviedetail.MovieDetailActivity;
import com.app.simplemvp.ui.adapter.MovieInfoAdapter;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

public class MovieActivity extends BaseActivity implements MovieContract.View{

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swiperefreshlayout)
    SwipeRefreshLayout swiperefreshlayout;

    private MovieContract.Presenter mPresenter;

    List<MovieInfo.SubjectsBean> listAll = new ArrayList<MovieInfo.SubjectsBean>();
    MovieInfoAdapter adapter;
    int start = 0;
    int count = 20;
    boolean isLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        //初始化Moviepresenter
        new MoviePresenter(this);
        //设置标题
        toolbar.setTitle("豆瓣电影TOP250");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //加载电影数据
        mPresenter.getMovieInfo(start, count);
        adapter = new MovieInfoAdapter(this, listAll);
        recyclerView.setAdapter(adapter);
        //设置加载动画颜色
        swiperefreshlayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        //设置下拉加载
        swiperefreshlayout.setOnRefreshListener(() -> mPresenter.getMovieInfo(start, count));
        //recycler滑动监听到最后一条然后加载更多
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition + 1 == adapter.getItemCount()) {
                    boolean isRefreshing = swiperefreshlayout.isRefreshing();
                    if (isRefreshing) {
                        adapter.notifyItemRemoved(adapter.getItemCount());
                        return;
                    }
                    if (!isLoading) {
                        isLoading = true;
                        loadMore();
                        isLoading = false;
                    }
                }
            }
        });
        //由于RecycleView需要自定义点击事件，所以在适配器中使用回调
        adapter.setOnItemClickListener((view, position) -> {
            Intent toDetail = new Intent(this, MovieDetailActivity.class);
            toDetail.putExtra("movieId", listAll.get(position).getId());
            toDetail.putExtra("movieName", listAll.get(position).getTitle());
            startActivity(toDetail);
        });
    }

    //加载更多
    private void loadMore() {
        start = start + count;
        mPresenter.getMovieInfo(start, count);
        adapter.notifyDataSetChanged();
        adapter.notifyItemRemoved(adapter.getItemCount());
    }


    @Override
    public void showMovieInfo(MovieInfo movieInfo) {
        start = movieInfo.getStart();
        listAll.addAll(movieInfo.getSubjects());
        adapter.notifyDataSetChanged();
        adapter.notifyItemRemoved(adapter.getItemCount());
    }

    @Override
    public void showLoading() {
        swiperefreshlayout.setRefreshing(true);
    }

    @Override
    public void dismissLoading() {
        swiperefreshlayout.setRefreshing(false);
    }

    @Override
    public void setPresenter(MovieContract.Presenter presenter) {
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
        swiperefreshlayout.setRefreshing(false);
        mPresenter.unsubscribe();
    }
}

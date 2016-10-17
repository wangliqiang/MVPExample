package com.app.mvp.ui.activity.douban.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.app.mvp.R;
import com.app.mvp.base.BaseActivity;
import com.app.mvp.model.MovieInfo;
import com.app.mvp.ui.activity.douban.moviedetail.MovieDetailActivity;
import com.app.mvp.ui.adapter.MovieInfoAdapter;

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
        //��ʼ��Moviepresenter
        new MoviePresenter(this);
        //����toolbar
        toolbar.setTitle("�����ӰTOP250");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //��ȡ����
        mPresenter.getMovieInfo(start, count);
        adapter = new MovieInfoAdapter(this, listAll);
        recyclerView.setAdapter(adapter);
        //��swiperefreshlayout��ɫ
        swiperefreshlayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        //����ˢ��
        swiperefreshlayout.setOnRefreshListener(() -> mPresenter.getMovieInfo(start, count));
        //recycler������������
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
        //RecycleAdapter ����¼��ص�
        adapter.setOnItemClickListener((view, position) -> {
            Intent toDetail = new Intent(this, MovieDetailActivity.class);
            toDetail.putExtra("movieId", listAll.get(position).getId());
            toDetail.putExtra("movieName", listAll.get(position).getTitle());
            startActivity(toDetail);
        });
    }

    //���ظ���
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

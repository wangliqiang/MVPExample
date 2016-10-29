package com.app.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.app.mvp.R;
import com.app.mvp.base.BaseActivity;
import com.app.mvp.ui.activity.douban.movie.MovieActivity;
import com.app.mvp.utils.Log;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.simplemvp)
    Button simplemvp;
    @Bind(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("MVPExample");
        setSupportActionBar(toolbar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.home, "home"))
                .addItem(new BottomNavigationItem(R.drawable.find, "find"))
                .addItem(new BottomNavigationItem(R.drawable.me, "me"))
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    @OnClick({R.id.simplemvp})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simplemvp:
                startActivity(new Intent(this, MovieActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabSelected(int position) {
        Log.e("position", position + "");
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}

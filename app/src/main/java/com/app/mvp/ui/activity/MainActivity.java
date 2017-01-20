package com.app.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.app.mvp.R;
import com.app.mvp.base.BaseActivity;
import com.app.mvp.ui.activity.bezier.BezierActivity;
import com.app.mvp.ui.activity.douban.MovieActivity;
import com.app.mvp.utils.ApkUtils;
import com.app.mvp.utils.Log;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.convert.FileConvert;
import com.lzy.okgo.convert.StringConvert;
import com.lzy.okrx.RxAdapter;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.simplemvp)
    Button simplemvp;
    @Bind(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    @Bind(R.id.bezier)
    Button bezier;
    @Bind(R.id.fileDownload)
    Button fileDownload;

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

    @OnClick({R.id.simplemvp,R.id.bezier,R.id.fileDownload})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simplemvp:
                startActivity(new Intent(this, MovieActivity.class));
                break;
            case R.id.bezier:
                startActivity(new Intent(this, BezierActivity.class));
                break;
            case R.id.fileDownload:
                fileDownload();
                break;
            default:
                break;
        }
    }

    //文件下载
    public void fileDownload(){
        OkGo.post("")
                .getCall(new FileConvert(), RxAdapter.<File>create())
                .doOnSubscribe(() -> showLoading())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(file -> {
                    dismissLoading();
                    fileDownload.setText("下载完成"+file.length());
                    ApkUtils.install(getApplicationContext(),file);
                }, throwable -> {
                    dismissLoading();
                    throwable.printStackTrace();
                    fileDownload.setText("下载失败");
                });
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

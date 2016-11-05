package com.app.mvp.ui.activity.bezier;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.app.mvp.R;
import com.app.mvp.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BezierActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier);
        ButterKnife.bind(this);

        toolbar.setTitle("贝塞尔曲线");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}

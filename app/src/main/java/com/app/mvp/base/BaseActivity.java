package com.app.mvp.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import butterknife.ButterKnife;

/**
 * Created by 王立强 on 2016/10/9.
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public void showError() {
        SnackbarManager.show(Snackbar.with(this).text("暂无数据").duration(Snackbar.SnackbarDuration.LENGTH_SHORT));
    }

//    private ProgressDialog dialog;
//
//    public void showLoading() {
//        if (dialog != null && dialog.isShowing()) return;
//        dialog = new ProgressDialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        dialog.setMessage("请求数据中...");
//        dialog.show();
//    }
//
//    public void dismissLoading() {
//        if (dialog != null && dialog.isShowing()) {
//            dialog.dismiss();
//        }
//    }
}

package com.pc.privacylibrary.base;

import android.os.Bundle;

import com.pc.privacylibrary.systempermission.StatusBarUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author: xyc
 * @date: 2022/3/24
 * @describe：
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide(); //隐藏标题栏
        }
        StatusBarUtils.initStatusBar(this, true, false);
    }
}

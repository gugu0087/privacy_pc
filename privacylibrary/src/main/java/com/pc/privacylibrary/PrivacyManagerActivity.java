package com.pc.privacylibrary;
import android.os.Bundle;
import android.widget.TextView;

import com.pc.privacylibrary.base.BaseActivity;


public abstract class PrivacyManagerActivity extends BaseActivity {

    /**
     * 个人信息查阅管理点击回调
     */
    protected abstract  void onPersonalInfoManager();
    /**
     * 个人信息下载
     */
    protected abstract  void onPersonalInfoDownload();

    /**
     * 系统权限
     */
    protected abstract  void onSystemPermission();

    /**
     * 隐私政策
     */
    protected abstract void onPrivacyPolicy();
    /**
     * 应用权限说明
     */
    protected abstract void onPermissionIntro();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_manager);
        findViewById(R.id.ivGoBack).setOnClickListener(view -> finish());
        ((TextView) findViewById(R.id.tvBarTitle)).setText("隐私管理");

        findViewById(R.id.csPersonalInfoManager).setOnClickListener(view -> onPersonalInfoManager());
        findViewById(R.id.csPersonInfoDownLoad).setOnClickListener(view -> onPersonalInfoDownload());
        findViewById(R.id.csSystemPermission).setOnClickListener(view -> onSystemPermission());
        findViewById(R.id.csPrivacyPolicy).setOnClickListener(view -> onPrivacyPolicy());
        findViewById(R.id.csPermissionIntro).setOnClickListener(view -> onPermissionIntro());

    }

}
package com.pc.privacylibrary;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pc.privacylibrary.base.BaseActivity;

import androidx.constraintlayout.widget.ConstraintLayout;

public abstract class PrivacyManagerActivity extends BaseActivity {

    private ConstraintLayout csPersonalInfoManager;
    private ConstraintLayout csPersonInfoDownLoad;
    private ConstraintLayout csSystemPermission;
    private ConstraintLayout csPrivacyPolicy;
    private ConstraintLayout csPermissionIntro;

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

        csPersonalInfoManager = findViewById(R.id.csPersonalInfoManager);
        csPersonInfoDownLoad = findViewById(R.id.csPersonInfoDownLoad);
        csSystemPermission = findViewById(R.id.csSystemPermission);
        csPrivacyPolicy = findViewById(R.id.csPrivacyPolicy);
        csPermissionIntro = findViewById(R.id.csPermissionIntro);

        csPersonalInfoManager.setOnClickListener(view -> onPersonalInfoManager());
        csPersonInfoDownLoad.setOnClickListener(view -> onPersonalInfoDownload());
        csSystemPermission.setOnClickListener(view -> onSystemPermission());
        csPrivacyPolicy.setOnClickListener(view -> onPrivacyPolicy());
        csPermissionIntro.setOnClickListener(view -> onPermissionIntro());

    }

}
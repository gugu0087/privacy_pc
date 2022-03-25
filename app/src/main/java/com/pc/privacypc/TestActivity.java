package com.pc.privacypc;

import android.content.Intent;
import android.util.Log;

import com.pc.privacylibrary.PrivacyManagerActivity;
import com.pc.privacylibrary.systempermission.SystemPermissionActivity;

public class TestActivity extends PrivacyManagerActivity {
    @Override
    protected void onPersonalInfoManager() {
        Log.d("xyc", "onGetPermission: sdsd");

    }

    @Override
    protected void onPersonalInfoDownload() {

    }

    @Override
    protected void onSystemPermission() {
        startActivity(new Intent(this, SystemPermissionActivity.class));
    }

    @Override
    protected void onPrivacyPolicy() {

    }

    @Override
    protected void onPermissionIntro() {

    }
}
package com.pc.privacypc;

import android.content.Intent;
import com.pc.privacylibrary.PrivacyManagerActivity;
import com.pc.privacylibrary.base.DataManager;
import com.pc.privacylibrary.personalinfo.PersonInfoDownLoadActivity;
import com.pc.privacylibrary.personalinfo.PersonInfoScanActivity;
import com.pc.privacylibrary.systempermission.SystemPermissionActivity;

public class TestActivity extends PrivacyManagerActivity {
    @Override
    protected void onPersonalInfoManager() {
        DataManager.phoneNumber = "18820126874";
        DataManager.registerTime= "2022-08-09";
        startActivity(new Intent(this, PersonInfoScanActivity.class));
    }

    @Override
    protected void onPersonalInfoDownload() {

      startActivity(new Intent(this, PersonInfoDownLoadActivity.class));
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
package com.pc.privacypc;

import android.content.Intent;

import com.pc.privacylibrary.PrivacyManagerActivity;
import com.pc.privacylibrary.base.DataManager;
import com.pc.privacylibrary.personalinfo.PersonInfoDownLoadActivity;
import com.pc.privacylibrary.personalinfo.PersonInfoScanActivity;
import com.pc.privacylibrary.personalinfo.UserItemBean;
import com.pc.privacylibrary.systempermission.SystemPermissionActivity;

import java.util.ArrayList;

public class TestActivity extends PrivacyManagerActivity {
    @Override
    protected void onPersonalInfoManager() {
        DataManager.phoneNumber = "18820126874";
        DataManager.registerTime = "2022-08-09";
        startActivity(new Intent(this, PersonInfoScanActivity.class));
    }

    private final ArrayList<UserItemBean> userList = new ArrayList<>();

    @Override
    protected void onPersonalInfoDownload() {
        userList.clear();
        UserItemBean bean1 = new UserItemBean();
        bean1.setKey("用户名");
        bean1.setValue("用户名");
        userList.add(bean1);

        UserItemBean bean2 = new UserItemBean();
        bean2.setKey("用户名");
        bean2.setValue("https://codesign.qq.com/s/dqN292gYod0aBXe/kv8398K85VjnKeg");

        userList.add(bean2);
        Intent intent = new Intent(this, PersonInfoDownLoadActivity.class);
        intent.putParcelableArrayListExtra(PersonInfoDownLoadActivity.USER_INFO, userList);
        startActivity(intent);
    }

    @Override
    protected void onSystemPermission() {
        startActivity(new Intent(this, SystemPermissionActivity.class));
    }

    @Override
    protected void onPrivacyPolicy() {

    }

    @Override
    protected void onPrivacyPolicyDsc() {

    }

    @Override
    protected void onPermissionIntro() {

    }
}
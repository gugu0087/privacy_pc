package com.pc.privacylibrary.personalinfo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.pc.privacylibrary.R;
import com.pc.privacylibrary.base.BaseActivity;

public class PersonInfoScanActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info_scan);
        ((TextView) findViewById(R.id.tvBarTitle)).setText("个人信息查阅与管理");
        findViewById(R.id.ivGoBack).setOnClickListener(view -> finish());

        findViewById(R.id.tvCount).setOnClickListener(
                view -> startActivity(new Intent(PersonInfoScanActivity.this, AccountInfoActivity.class)));
        findViewById(R.id.tvAppInfo).setOnClickListener(
                view -> startActivity(new Intent(PersonInfoScanActivity.this, AppInfoActivity.class)));
    }
}
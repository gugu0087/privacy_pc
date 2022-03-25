package com.pc.privacylibrary.personalinfo;

import android.os.Bundle;
import android.widget.TextView;

import com.pc.privacylibrary.R;
import com.pc.privacylibrary.base.BaseActivity;
import com.pc.privacylibrary.base.DataManager;

public class AccountInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        ((TextView) findViewById(R.id.tvBarTitle)).setText("账号资料");
        ((TextView) findViewById(R.id.tvNumber)).setText(DataManager.phoneNumber);
        ((TextView) findViewById(R.id.tvRegisterTime)).setText(DataManager.registerTime);
    }
}
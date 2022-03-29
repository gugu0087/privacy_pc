package com.pc.privacylibrary.personalinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pc.privacylibrary.R;
import com.pc.privacylibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class PersonInfoDownLoadActivity extends BaseActivity {

    private LinearLayout llPersonInfo;
    private EditText edtEmail;
    private TextView tvDownLoad;
    private List<UserItemBean> userList = new ArrayList<>();
    public static final String USER_INFO = "user_info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        ((TextView) findViewById(R.id.tvBarTitle)).setText("个人信息下载");
        llPersonInfo = findViewById(R.id.llPersonInfo);
        edtEmail = findViewById(R.id.edtEmail);
        tvDownLoad = findViewById(R.id.tvDownLoad);
        getIntentData();
        updateUI();

    }

    private void updateUI() {
        if (llPersonInfo.getChildCount() > 0) {
            llPersonInfo.removeAllViews();
        }
        for (int i = 0; i < userList.size(); i++) {
            PersonInfoItemView itemView = new PersonInfoItemView(this);
            UserItemBean userInfoBean = userList.get(i);
            itemView.setData(userInfoBean.getKey(), userInfoBean.getValue());
            llPersonInfo.addView(itemView);
        }
    }

    private void getIntentData() {
        Intent intent = getIntent();
        List<UserItemBean> params = intent.getParcelableArrayListExtra(USER_INFO);
        if (params == null || params.size() == 0) {
            findViewById(R.id.tvTips2).setVisibility(View.GONE);
            return;
        }
        userList.clear();
        userList.addAll(params);
    }

}
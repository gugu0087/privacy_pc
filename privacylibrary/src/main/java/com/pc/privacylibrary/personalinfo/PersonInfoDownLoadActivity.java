package com.pc.privacylibrary.personalinfo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pc.privacylibrary.R;
import com.pc.privacylibrary.base.BaseActivity;
import com.pc.privacylibrary.base.CheckEmail;
import com.pc.privacylibrary.base.DownInfoSuccessListener;
import com.pc.privacylibrary.base.PersonInfoDLManager;
import com.pc.privacylibrary.util.ToastView;

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
        ((TextView) findViewById(R.id.tvBarTitle)).setText("信息下载管理页");
        findViewById(R.id.ivGoBack).setOnClickListener(view -> finish());
        llPersonInfo = findViewById(R.id.llPersonInfo);
        edtEmail = findViewById(R.id.edtEmail);
        tvDownLoad = findViewById(R.id.tvDownLoad);
        tvDownLoad.setOnClickListener(view -> {
            checkEmail();
        });
        getIntentData();
        updateUI();

    }

    private void checkEmail() {
        String email = edtEmail.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            ToastView.showCenterToast(PersonInfoDownLoadActivity.this, "请输入邮箱");
            return;
        }
        if (!CheckEmail.checkEmail(email)) {// 验证邮箱
            ToastView.showCenterToast(PersonInfoDownLoadActivity.this, email + "不是合法的邮箱名。");
            return;
        }
        //tvDownLoad.setEnabled(false);
        PersonInfoDLManager.getInstance().notifyListener(email, new DownInfoSuccessListener() {
            @Override
            public void onSuccess(boolean isSuccess) {
                Intent intent = new Intent(PersonInfoDownLoadActivity.this, PersonInfoDownLoadFinishActivity.class);
                intent.putExtra(PersonInfoDownLoadFinishActivity.EMAIL_KEY, email);
                intent.putExtras(intent);
                startActivity(intent);
                //tvDownLoad.setEnabled(true);
            }

            @Override
            public void onFail(String error) {
                //tvDownLoad.setEnabled(true);
                if (TextUtils.isEmpty(error)) {
                    ToastView.showCenterToast(PersonInfoDownLoadActivity.this, "服务器繁忙，请稍后重试");
                    return;
                }
                ToastView.showCenterToast(PersonInfoDownLoadActivity.this, error);
            }
        });
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
package com.pc.privacylibrary.personalinfo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pc.privacylibrary.R;
import com.pc.privacylibrary.base.BaseActivity;
import com.pc.privacylibrary.base.DisplayUtil;

public class PersonInfoDownLoadFinishActivity extends BaseActivity {

    private ImageView ivGoBack;
    private TextView tvWarn;
    private TextView tvKnow;
    public static final String EMAIL_KEY = "email";
    private String emailInfo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_info_finish);
        ivGoBack = findViewById(R.id.ivGoBack);
        tvWarn = findViewById(R.id.tvWarn);
        tvKnow = findViewById(R.id.tvKnow);
        ViewGroup.LayoutParams layoutParams = ivGoBack.getLayoutParams();
        layoutParams.width = DisplayUtil.dip2px(this,15f);
        layoutParams.height = DisplayUtil.dip2px(this,15f);
        ivGoBack.setLayoutParams(layoutParams);
        ivGoBack.setImageResource(R.mipmap.gray_small_close_icon);

        ivGoBack.setOnClickListener(view -> finish());
        tvKnow.setOnClickListener(view -> finish());
        Intent intent = getIntent();
        if (intent != null) {
            emailInfo = intent.getStringExtra(EMAIL_KEY);
        }
        if (!TextUtils.isEmpty(emailInfo)) {
            tvWarn.setText(getString(R.string.info_download_warn) + emailInfo);
        }
    }

}
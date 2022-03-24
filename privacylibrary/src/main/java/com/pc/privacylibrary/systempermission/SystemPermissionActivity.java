package com.pc.privacylibrary.systempermission;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.pc.privacylibrary.R;
import com.pc.privacylibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 系统权限管理
 */
public class SystemPermissionActivity extends BaseActivity {

    private RecyclerView recycleView;
    private List<PrivacyBean> resultList;
    private PrivacyItemAdapter itemAdapter;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_permission);
        initView();
        initData();
    }

    private void initView() {
        recycleView = findViewById(R.id.recycleView);
        ivBack = findViewById(R.id.ivBack);
        resultList = new ArrayList<>();
        itemAdapter = new PrivacyItemAdapter(this, resultList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setAdapter(itemAdapter);
        itemAdapter.setOnItemClickListener(v -> startActivity(getAppDetailSettingIntent()));
        ivBack.setOnClickListener(v -> finish());
        findViewById(R.id.tvToSettings).setOnClickListener(v -> startActivity(getAppDetailSettingIntent()));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initData() {
        PrivacyBean bean1 = new PrivacyBean();
        bean1.setLeftIcon(R.mipmap.location);
        bean1.setName("位置");
        PrivacyBean bean2 = new PrivacyBean();
        bean2.setName("相机");
        bean2.setLeftIcon(R.mipmap.camera);

        PrivacyBean bean3 = new PrivacyBean();
        bean3.setName("照片");
        bean3.setLeftIcon(R.mipmap.picture);

        resultList.add(bean1);
        resultList.add(bean2);
        resultList.add(bean3);
        itemAdapter.notifyDataSetChanged();
    }

    /**
     * 获取应用详情页面intent
     *
     * @return
     */
    private Intent getAppDetailSettingIntent() {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent.setData(Uri.fromParts("package", getPackageName(), null));
        return localIntent;
    }
}
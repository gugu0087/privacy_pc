package com.pc.privacylibrary.systempermission;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.pc.privacylibrary.R;
import com.pc.privacylibrary.base.BaseActivity;
import com.pc.privacylibrary.base.PermissionUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 系统权限管理
 */
public class SystemPermissionActivity extends BaseActivity {
    private final List<PrivacyBean> resultList = new ArrayList<>();
    private PrivacyItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_permission);
        initView();
        initDefaultData();
    }

    private void initView() {

        RecyclerView recycleView = findViewById(R.id.recycleView);
        itemAdapter = new PrivacyItemAdapter(this, resultList);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(itemAdapter);
        itemAdapter.setOnItemClickListener(v -> startActivity(getAppDetailSettingIntent()));
        findViewById(R.id.ivBack).setOnClickListener(v -> finish());
        findViewById(R.id.tvToSettings).setOnClickListener(v -> startActivity(getAppDetailSettingIntent()));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void initDefaultData() {
        List<PrivacyBean> grantedList = PermissionUtils.getGrantedList(this);
        if (grantedList.size() == 0) {
            return;
        }
        resultList.clear();
        resultList.addAll(grantedList);
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
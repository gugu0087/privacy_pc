package com.pc.privacylibrary.systempermission;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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
    public static String LIST_PARAMS = "resultList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_permission);
        ((TextView) findViewById(R.id.tvBarTitle)).setText("系统权限管理");
        PermissionUtils.init();
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getIntentData();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void getIntentData() {
        Intent intent = getIntent();
        try {
            List<PrivacyBean> params = intent.getParcelableArrayListExtra(LIST_PARAMS);
            if (params == null || params.size() == 0) {
                initDefaultData();
                return;
            }
            List<PrivacyBean> privacyBeans = PermissionUtils.checkGrandState(this, params);
            resultList.clear();
            resultList.addAll(privacyBeans);
            itemAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            Log.d("xyc", "getIntentData: e=" + e.getMessage());
            initDefaultData();
        }
    }

    private void initView() {

        RecyclerView recycleView = findViewById(R.id.recycleView);
        itemAdapter = new PrivacyItemAdapter(this, resultList);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        recycleView.setAdapter(itemAdapter);
        itemAdapter.setOnItemClickListener(v -> startActivity(getAppDetailSettingIntent()));
        findViewById(R.id.ivGoBack).setOnClickListener(v -> finish());

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
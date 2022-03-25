package com.pc.privacylibrary.personalinfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.pc.privacylibrary.R;
import com.pc.privacylibrary.base.BaseActivity;

public class AppInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);
        ((TextView) findViewById(R.id.tvBarTitle)).setText("应用相关信息");
        try {
            int labelRes = this.getApplicationInfo().labelRes;
            String label = this.getResources().getString(labelRes);
            ((TextView) findViewById(R.id.tvAppName)).setText(label);
            ((TextView) findViewById(R.id.tvVersion)).setText(getVersionName(this));
        } catch (Exception e) {
            Log.d("xyc", "onCreate: e=" + e.getMessage());
        }
    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context
     * @return 当前应用的版本名称
     */
    public static synchronized String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
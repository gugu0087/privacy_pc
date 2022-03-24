package com.pc.privacylibrary.base;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import com.pc.privacylibrary.R;
import com.pc.privacylibrary.systempermission.PrivacyBean;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

import androidx.core.content.ContextCompat;

/**
 * @author: xyc
 * @date: 2022/3/24
 * @describe：
 */
public class PermissionUtils {
    public static List<PrivacyBean> permissions = new ArrayList<>();

    public static void init() {
        if (permissions.size() > 0) {
            permissions.clear();
        }
        PrivacyBean bean1 = new PrivacyBean();
        bean1.setName("存储");
        bean1.setManifest("1");
        bean1.setLeftIcon(R.mipmap.storage);
        bean1.setManifest(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        bean1.setManifestExtra(Manifest.permission.READ_EXTERNAL_STORAGE);
        permissions.add(bean1);

        PrivacyBean bean2 = new PrivacyBean();
        bean2.setName("日历");
        bean2.setManifest("2");
        bean2.setLeftIcon(R.mipmap.calendar);
        bean2.setManifest(Manifest.permission.READ_CALENDAR);
        bean2.setManifestExtra(Manifest.permission.WRITE_CALENDAR);
        permissions.add(bean2);

        PrivacyBean bean3 = new PrivacyBean();
        bean3.setName("相机");
        bean3.setManifest("3");
        bean3.setLeftIcon(R.mipmap.camera);
        bean3.setManifest(Manifest.permission.CAMERA);
        permissions.add(bean3);


        PrivacyBean bean4 = new PrivacyBean();
        bean4.setName("位置");
        bean4.setManifest("4");
        bean4.setLeftIcon(R.mipmap.location);
        bean4.setManifest(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(bean4);

        PrivacyBean bean5 = new PrivacyBean();
        bean5.setName("麦克风");
        bean5.setManifest("5");
        bean5.setLeftIcon(R.mipmap.record);
        bean5.setManifest(Manifest.permission.RECORD_AUDIO);
        permissions.add(bean5);


        PrivacyBean bean6 = new PrivacyBean();
        bean6.setName("手机");
        bean6.setManifest("6");
        bean6.setLeftIcon(R.mipmap.phone);
        bean6.setManifest(Manifest.permission.READ_PHONE_STATE);
        permissions.add(bean6);

        PrivacyBean bean7 = new PrivacyBean();
        bean7.setName("通讯录");
        bean7.setManifest("7");
        bean7.setLeftIcon(R.mipmap.contract);
        bean6.setManifest(Manifest.permission.WRITE_CONTACTS);
        bean6.setManifestExtra(Manifest.permission.READ_CONTACTS);
        permissions.add(bean7);

        PrivacyBean bean8 = new PrivacyBean();
        bean8.setName("短信");
        bean8.setManifest("8");
        bean8.setLeftIcon(R.mipmap.sms);
        bean8.setManifest(Manifest.permission.READ_SMS);
        bean8.setManifestExtra(Manifest.permission.SEND_SMS);

        permissions.add(bean8);

        PrivacyBean bean9 = new PrivacyBean();
        bean9.setName("电话");
        bean9.setManifest("8");
        bean9.setLeftIcon(R.mipmap.call_phone);
        bean9.setManifest(Manifest.permission.CALL_PHONE);

        permissions.add(bean9);

    }

    public static List<PrivacyBean> getGrantedList(Context context) {
        List<PrivacyBean> grantedList = new ArrayList<>();
        for (int i = 0; i < permissions.size(); i++) {
            String manifest = permissions.get(i).getManifest();
            String manifestExtra = permissions.get(i).getManifestExtra();
            int code = ContextCompat.checkSelfPermission(context, manifest);
            int codeExtra = -99;
            if (manifestExtra != null) {
                codeExtra = ContextCompat.checkSelfPermission(context, manifestExtra);
            }
            if (code == PackageManager.PERMISSION_GRANTED || codeExtra == PackageManager.PERMISSION_GRANTED) {
                grantedList.add(permissions.get(i));
            }
        }
        return grantedList;
    }
}

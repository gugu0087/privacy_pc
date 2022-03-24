package com.pc.privacylibrary.systempermission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.pc.privacylibrary.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class StatusBarUtils {
    /**
     * 沉浸式状态栏
     *
     * @param activity
     * @param isLightStatusBar 是否为浅色状态栏（黑色字体图标）
     * @param isTransStatusBar 是否为透明状态栏
     */
    public static void initStatusBar(Activity activity, boolean isLightStatusBar, boolean isTransStatusBar) {
        // 6.0以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 设置浅色状态栏(神色背景图标)
            StatusBarUtils.setStatusBarLightMode(activity, isLightStatusBar);
            // 透明状态栏
            if (isTransStatusBar) {
                StatusBarUtils.setTransStatusBar(activity, isLightStatusBar);
            }else {
                setStatusBarColor(activity, R.color.white);
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }

    /**
     * 修改状态栏颜色，支持4.4以上版本
     *
     * @param activity
     * @param colorId
     */
    public static void setStatusBarColor(Activity activity, int colorId) {
        //5.0+
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(activity.getResources().getColor(colorId));
    }

    /**
     * 透明状态栏
     *
     * @param isLightStatusBar 浅色状态栏(黑色字体、图标)
     */
    private static void setTransStatusBar(Activity activity, boolean isLightStatusBar) {
        // 大于android 5.0
        Window window = activity.getWindow();
        // 清除状态 透明的状态栏| 透明导航栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        // 大于 android 6.0
        if (isLightStatusBar && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 6.0增加了View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR，这个字段就是把状态栏标记为浅色，然后状态栏的字体颜色自动转换为深色。
            // 所以，如果需要浅色的状态栏，只能在Android6.0及以后的版本中实现
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }


    /**
     * 设置状态栏黑色字体图标，
     * 适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android
     *
     * @param activity
     * @param dark     是否把状态栏字体及图标颜色设置为深色
     */
    public static void setStatusBarLightMode(Activity activity, boolean dark) {
        if (MIUISetStatusBarLightMode(activity.getWindow(), dark)) {
        } else if (isFlymeOS()) {
            // 设置魅族状态栏 深浅颜色
            StatusBarColorUtils.setStatusBarDarkIcon(activity, dark);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    /**
     * 设置状态栏字体图标为深色，需要MIUIV6以上
     *
     * @param window 需要设置的窗口
     * @param dark   是否把状态栏字体及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    private static boolean MIUISetStatusBarLightMode(Window window, boolean dark) {
        boolean result = false;
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                @SuppressLint("PrivateApi") Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (dark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);//状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
                }
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }


    // ############################魅族系统判断#####################################

    // 判断是魅族操作系统
    public static boolean isFlymeOS() {
        return getMeizuFlymeOSFlag().toLowerCase().contains("flyme");
    }

    /**
     * 获取魅族系统操作版本标识
     */
    private static String getMeizuFlymeOSFlag() {
        String str = getSystemProperty("ro.build.display.id", "");
        return str;
    }

    private static String getSystemProperty(String key, String defaultValue) {
        try {
            Class<?> clz = Class.forName("android.os.SystemProperties");
            Method get = clz.getMethod("get", String.class, String.class);
            return (String) get.invoke(clz, key, defaultValue);
        } catch (Exception e) {
        }
        return defaultValue;
    }

}

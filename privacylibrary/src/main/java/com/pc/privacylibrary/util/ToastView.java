package com.pc.privacylibrary.util;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pc.privacylibrary.R;

/**
 * author : liaominggui
 * e-mail : liaominggui@pconline.com.cn
 * date   : 2020/10/2110:35
 * desc   :
 */
public class ToastView {
    /**
     * 居中带图片toaset
     *
     * @param txt
     */
    public static void showCenterToastPhoto(Context context, String txt) {
        Toast toast = Toast.makeText(context, txt, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        TextView tvMsg = view.findViewById(R.id.tvMsg);
        tvMsg.setText(txt);
        toast.setView(view);
        toast.show();
    }


    /**
     * 居中不带图片toaset
     *
     * @param txt
     */
    public static void showCenterToast(Context context, String txt) {
        Toast toast = Toast.makeText(context, txt, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        TextView tvMsg = view.findViewById(R.id.tvMsg);
        tvMsg.setText(txt);
        toast.setView(view);
        toast.show();
    }

}

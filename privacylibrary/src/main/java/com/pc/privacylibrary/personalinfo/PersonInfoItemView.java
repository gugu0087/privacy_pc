package com.pc.privacylibrary.personalinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.pc.privacylibrary.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * @author: xyc
 * @date: 2022/3/28
 * @describe：
 */
public class PersonInfoItemView extends ConstraintLayout {

    private TextView tvNameTip;
    private TextView tvContent;

    public PersonInfoItemView(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.person_info_item_view, this);
        initView();
    }

    public PersonInfoItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void initView() {
        tvNameTip = findViewById(R.id.tvNameTip);
        tvContent = findViewById(R.id.tvContent);

    }

    public void setData(String nameTip, String content) {
        tvNameTip.setText(nameTip);
        tvContent.setText(content);
    }

}

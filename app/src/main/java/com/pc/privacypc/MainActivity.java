package com.pc.privacypc;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.pc.privacylibrary.PrivacyManagerActivity;
import com.pc.privacylibrary.systempermission.PrivacyBean;
import com.pc.privacylibrary.systempermission.SystemPermissionActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tvClick).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
            @Override
            public void onClick(View view) {
              //  startActivity(new Intent(MainActivity.this, SystemPermissionActivity.class));
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });
    }
}
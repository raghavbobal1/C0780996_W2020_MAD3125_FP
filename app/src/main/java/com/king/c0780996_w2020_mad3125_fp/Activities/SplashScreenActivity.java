package com.king.c0780996_w2020_mad3125_fp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.king.c0780996_w2020_mad3125_fp.R;

public class SplashScreenActivity extends AppCompatActivity {


        Handler handler;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_screen);

            ActionBar mActionBar = getSupportActionBar();
            mActionBar.hide();

            handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            },5000);
        }
    }

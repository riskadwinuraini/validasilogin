package com.riska.validasi_login;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import android.os.Bundle;
import android.window.SplashScreen;

public class splash extends AppCompatActivity {

    public static final String FILENAME = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLogin()) {
                    Intent intent = new Intent(splash.this,MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(splash.this,login.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 3000);
    }

    boolean isLogin() {
        File sdcard = getFilesDir();
        File file = new File(sdcard, FILENAME);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }
}
package com.asia.delmaratallah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
//private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        progressBar = (ProgressBar) findViewById(R.id.progress);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                upwork();
                startApp();
            }
        }).start();

    }

    private void upwork() {
        for (int i = 0; i <= 100; i += 1) {
            try {
                Thread.sleep(50);
//                progressBar.setProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(SplashScreen.this, Login.class);
        startActivity(intent);
    }
}
package com.example.sergio.sergioromerosegundo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {

    ProgressBar pb;
    int miProgreso=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pb = findViewById(R.id.pb1);
        new Thread(miHilo).start();
    }
    private Runnable miHilo = new Runnable() {
        @Override
        public void run() {
            while(miProgreso<100){
                try {
                    miHandle.sendMessage(miHandle.obtainMessage());
                    Thread.sleep(20);
                } catch(Throwable t){}
            }

            Intent i=new Intent(Splash.this, MainActivity.class);
            startActivity(i);
            finish();

        }

        Handler miHandle=new Handler(){

            public void handleMessage(Message msg){
                miProgreso++;
                pb.setProgress(miProgreso);
            }
        };
    };
}

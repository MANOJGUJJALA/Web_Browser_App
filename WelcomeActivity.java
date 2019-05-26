package com.example.androidwebbrowser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Thread o=new Thread()
        {
            public void run()
            {
                try{
                    sleep(4000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent ho=new Intent(WelcomeActivity.this,HomeActivity.class);
                    startActivity(ho);
                }
            }
        };
        o.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

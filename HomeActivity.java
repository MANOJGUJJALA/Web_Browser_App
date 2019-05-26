package com.example.androidwebbrowser;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener
{


    private Button searchbuttonhome;
    private EditText inputurl;
    private Button fb;
    private  Button yt;
    private Button gm;
    private Button goo;
    private Button hrk;
    private Button instgm;

    private ProgressDialog Loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Loading=new ProgressDialog(this);

        fb=(Button)findViewById(R.id.face_book);
        yt=(Button)findViewById(R.id.youtube);
        gm=(Button)findViewById(R.id.gmail);
        goo=(Button)findViewById(R.id.google);
        instgm=(Button)findViewById(R.id.instagram);
        hrk=(Button)findViewById(R.id.hackerrank);

        searchbuttonhome =(Button)findViewById(R.id.search_button_home);
        inputurl=(EditText)findViewById(R.id.search_url_home);
        searchbuttonhome.setOnClickListener(this);


        Loading.setTitle(" WEB BROWSER   :)");
        Loading.setMessage("Welcome To The Fastest Browser   ");
        Loading.show();

        fb.setOnClickListener(this);
        yt.setOnClickListener(this);
        gm.setOnClickListener(this);
        goo.setOnClickListener(this);
        instgm.setOnClickListener(this);
        hrk.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)
    {
        if(v==searchbuttonhome)
        {
            openwebsite();
        }
        if(v==fb)
        {
            Intent fab=new Intent(HomeActivity.this,UrlSearch.class);
            fab.putExtra("url_address","https://www.facebook.com");
            startActivity(fab);
        }
        if(v==yt)
        {
            Intent YOUTUBE=new Intent(HomeActivity.this,UrlSearch.class);
            YOUTUBE.putExtra("url_address","https://www.youtube.com");
            startActivity(YOUTUBE);
        }
        if(v==hrk)
        {
            Intent hkr=new Intent(HomeActivity.this,UrlSearch.class);
            hkr.putExtra("url_address","https://www.hackerrank.com");
            startActivity(hkr);
        }
        if(v==gm)
        {
            Intent GMAIL=new Intent(HomeActivity.this,UrlSearch.class);
            GMAIL.putExtra("url_address","https://www.gmail.com");
            startActivity(GMAIL);
        }
        if(v==goo)
        {
            Intent GOOGLE=new Intent(HomeActivity.this,UrlSearch.class);
            GOOGLE.putExtra("url_address","https://www.google.com");
            startActivity(GOOGLE);
        }
        if(v==instgm)
        {
            Intent INSTAGRAM=new Intent(HomeActivity.this,UrlSearch.class);
            INSTAGRAM.putExtra("url_address","https://www.instagram.com");
            startActivity(INSTAGRAM);
        }


    }

    private void openwebsite()
    {

        Loading.setTitle("Loading..");
        Loading.setMessage("Please wait while loading  :) ");
        Loading.show();

        String s=inputurl.getText().toString();
        if(TextUtils.isEmpty(s))
        {
            Toast t= (Toast) Toast.makeText(HomeActivity.this,"please enter url or web adress",Toast.LENGTH_LONG);
            t.show();
        }
        else
        {
            String wiouthttps=s.replace("https://","");
            String w=wiouthttps.replace("www.","");
            String witocom=w.replace(".com","");
            String ht="https://";
            String www="www.";
            String com=".com";
            Intent ser=new Intent(HomeActivity.this,UrlSearch.class);
            ser.putExtra("url_address",ht+www+witocom+com);
            startActivity(ser);

            inputurl.setText("");
            inputurl.requestFocus();

        }
    }
}

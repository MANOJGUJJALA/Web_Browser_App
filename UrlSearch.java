package com.example.androidwebbrowser;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.String;

public  class UrlSearch extends AppCompatActivity implements View.OnClickListener
{

    private Button search_url_button;
    private EditText Url_input;
    private Button HomeButton;
    private WebView search_web_address;
    String url;

    private ProgressDialog Loading;
    @SuppressLint({"WrongViewCast", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_search);


        Loading=new ProgressDialog(this);

        search_url_button=(Button)findViewById(R.id.search_url_button);
        Url_input=(EditText)findViewById(R.id.input_search_url);
        HomeButton=(Button)findViewById(R.id.home_button);
        search_web_address=(WebView)findViewById(R.id.search_web_site);

        WebSettings webSettings = search_web_address.getSettings();
        webSettings.setJavaScriptEnabled(true);



        url= (String) getIntent().getExtras().get("url_address").toString();
        Url_input.setText(url);

        search_web_address.loadUrl(url);
        search_web_address.setWebViewClient(new WebViewClient());
        Loading.setTitle(" Loading..");
        Loading.setMessage("Please Wait  :) ");
        Loading.show();

        search_url_button.setOnClickListener(this);
        HomeButton.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        if(search_web_address.canGoBack())
        {
            search_web_address.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v)
    {
        if(v==HomeButton)
        {
            finish();
            Intent h=new Intent(UrlSearch.this,HomeActivity.class);
            startActivity(h);
        }
        if(v==search_url_button)
        {
            searchwebaddress();
        }

    }

    private void searchwebaddress()
    {

        Loading.setTitle("Loading..");
        Loading.setMessage("Please wait while loading  :) ");
        Loading.show();


        String s=Url_input.getText().toString();
        if(TextUtils.isEmpty(s))
        {
            Toast t= (Toast) Toast.makeText(UrlSearch.this,"please enter url or web adress",Toast.LENGTH_LONG);
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
            Intent ser=new Intent(UrlSearch.this,UrlSearch.class);
            ser.putExtra("url_address",ht+www+witocom+com);
            startActivity(ser);

            Url_input.setText("");
            Url_input.requestFocus();
        }
    }
}

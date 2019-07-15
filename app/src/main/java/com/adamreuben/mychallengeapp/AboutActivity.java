package com.adamreuben.mychallengeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    private WebView webView;
    private ImageView status;
    private ProgressDialog progressDialog;
    private String url = getResources().getString(R.string.url);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        webView = findViewById(R.id.webview);
        status = findViewById(R.id.status_icon);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        checkConnection();

    }


     protected boolean isOnline(){

         ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

         NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

         if (networkInfo != null && networkInfo.isConnectedOrConnecting()){
             return true;
         }else {
             return false;
         }

     }

     public void checkConnection(){

        if (isOnline()){

            webView.loadUrl(url);


        }else{

            webView.setVisibility(View.GONE);
            status.setVisibility(View.VISIBLE);

            Toast.makeText(AboutActivity.this, "Check Your Internet Connections", Toast.LENGTH_LONG).show();

        }
     }

     public class WebClientClass extends WebViewClient{
         @Override
         public boolean shouldOverrideUrlLoading(WebView view, String url) {

             progressDialog.show();

             return true;
         }

         @Override
         public void onPageFinished(WebView view, String url) {
             super.onPageFinished(view, url);

             progressDialog.dismiss();

         }

         @Override
         public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
             super.onReceivedSslError(view, handler, error);

             Toast.makeText(AboutActivity.this, "Can't Load Your Url", Toast.LENGTH_LONG).show();


         }
     }


}

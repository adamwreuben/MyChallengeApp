package com.adamreuben.mychallengeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button myProfileBtn,aboutAlcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myProfileBtn = findViewById(R.id.myProfileBtn);
        aboutAlcBtn = findViewById(R.id.aboutBtn);

        myProfileBtn.setOnClickListener(this);
        aboutAlcBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

       if (view.getId() == R.id.myProfileBtn){

           startActivity(new Intent(MainActivity.this,MyProfileActivity.class));

       }else if (view.getId() == R.id.aboutBtn){

           startActivity(new Intent(MainActivity.this,AboutActivity.class));
       }

    }
}

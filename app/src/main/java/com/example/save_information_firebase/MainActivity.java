package com.example.save_information_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //pass to entry data in next view
    public void nextActivity(View v){
        Intent nextview = new Intent(this,person_information.class);
        startActivity(nextview);}
}
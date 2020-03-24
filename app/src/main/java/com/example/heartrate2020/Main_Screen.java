package com.example.heartrate2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__screen);

    }

    public void ViewP (View view)
    {
            Intent intent = new Intent(Main_Screen.this ,Pation_Profile.class);
            startActivity(intent);
    }

}

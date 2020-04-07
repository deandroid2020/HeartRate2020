package com.example.heartrate2020.My_Acts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.heartrate2020.MainActivity;
import com.example.heartrate2020.R;
import com.example.heartrate2020.Session;

public class PatientPage extends AppCompatActivity {

    Session session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientpage);























        session =new Session(getApplicationContext());


    }


    public void Logout(View view) {

        session.LogOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }
}
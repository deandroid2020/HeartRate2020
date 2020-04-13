package com.example.heartrate2020.My_Acts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.heartrate2020.MainActivity;
import com.example.heartrate2020.R;
import com.example.heartrate2020.Session;

public class PatientPage extends AppCompatActivity {

    Session session;
ImageView updatemyownp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientpage);



        updatemyownp=findViewById(R.id.ownprofile);
updatemyownp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),updatemyownprofile.class));
    }
});





















        session =new Session(getApplicationContext());


    }


    public void Logout(View view) {

        session.LogOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }
}
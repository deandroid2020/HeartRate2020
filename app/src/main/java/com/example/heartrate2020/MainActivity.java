package com.example.heartrate2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.PasspointConfiguration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.PasswordAuthentication;

public class MainActivity extends AppCompatActivity {

    String UserName = "reem";
    String Passcode = "102030";
    EditText passwordtext;
    EditText usertext;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.loginbutton);
        passwordtext = findViewById(R.id.passwordinput);
        usertext = findViewById(R.id.userinput);


        //creating static usernames and passwords

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (UserName.equals(usertext.getText().toString()) && Passcode.equals(passwordtext.getText().toString()))

                {
                    Intent intent = new Intent(MainActivity.this ,Main_Screen.class);
                    startActivity(intent);
                }

                else
                  Toast.makeText(getApplicationContext(),"User Name Or password is not corect!!",Toast.LENGTH_LONG).show();


            }
        });



    }
}

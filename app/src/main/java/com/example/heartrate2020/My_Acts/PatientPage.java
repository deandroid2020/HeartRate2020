package com.example.heartrate2020.My_Acts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heartrate2020.MainActivity;
import com.example.heartrate2020.R;
import com.example.heartrate2020.Session;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PatientPage extends AppCompatActivity {

    Session session;
    ImageView updatemyownp;
    ImageView btnhistory;
    TextView phrate,HeartRateStatus;
   String TAG="----";
   Location location;
    LatLng latLng;
    int ReadingRate=103;

    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientpage);


phrate =findViewById(R.id.patientpagehrate);
phrate.setText(String.valueOf(ReadingRate));
HeartRateStatus=findViewById(R.id.patientpagestavalue);

btnhistory=findViewById(R.id.histrecored);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);



btnhistory.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        startActivity(new Intent(getApplicationContext(),Historyrecoerds.class));
    }
});

        updatemyownp=findViewById(R.id.ownprofile);
updatemyownp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(),updatemyownprofile.class));
    }
});






        session =new Session(getApplicationContext());

         latLng= new LatLng(2.22,3.33);

        UpdateReading(ReadingRate,latLng);

    }//end of create

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){


            case R.id.menuLogout:
                session.LogOut();
                startActivity(new Intent(getApplicationContext(), LogIn.class));
                Toast.makeText(this, "You are logging out", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuAbout:
                session.LogOut();
                startActivity(new Intent(getApplicationContext(), LogIn.class));
                //  Toast.makeText(this, "You are logging out", Toast.LENGTH_SHORT).show();
                break;




        }
        return true;
    }



    private void UpdateReading(int Beats, LatLng location){
        final Map<String, Object> data = new HashMap<>();

        data.put("heart_rate", Beats);
        data.put("PId","1009");
        data.put("time", new Date());


        if (Beats >100 || Beats<50){

            data.put("Location",location);

        }




        db.collection("heartrate").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                         Log.d(TAG, "Data inserted..: " + documentReference.getId());
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //          Log.w(TAG, "Error adding document", e);
                    }
                });


    }








    public void Logout(View view) {

        session.LogOut();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }


}
package com.example.heartrate2020.My_Acts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.heartrate2020.CustomItemClickListener;
import com.example.heartrate2020.Model.Pationt;
import com.example.heartrate2020.MyAdaptors.AlertAdaptor;
import com.example.heartrate2020.MyAdaptors.PatientListAdaptor;
import com.example.heartrate2020.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Alert extends AppCompatActivity {


    ListView listView;
    List<com.example.heartrate2020.Model.Alert> alertList = new ArrayList<>();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    AlertAdaptor alertAdaptor;
    String TAG;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        alertAdaptor=new AlertAdaptor(this,alertList);
        listView=findViewById(R.id.alertlistv);
        listView.setAdapter(alertAdaptor);
        getalert();
    }


    public void getalert() {

        db.collection("Alert")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful())
                        {
                            com.example.heartrate2020.Model.Alert a;
                            for (QueryDocumentSnapshot document : task.getResult())
                            {


                                    Log.d(TAG, "=============>" + document.getId());

                                    a= new com.example.heartrate2020.Model.Alert();


                                    a.setName(document.get("name").toString());
                                    a.setHrate(document.get("hrate").toString());
                                    a.setTimealert(document.get("time").toString());

                                    alertList.add(a);
                                    alertAdaptor.notifyDataSetChanged();


                                //     String s  = document.get("").toString();
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });//end addOnCompleteListener
    }//end getpaitent
}

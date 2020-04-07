package com.example.heartrate2020.My_Acts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.heartrate2020.CustomItemClickListener;
import com.example.heartrate2020.Model.Pationt;
import com.example.heartrate2020.MyAdaptors.PatientListAdaptor;
import com.example.heartrate2020.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ManagePatient extends AppCompatActivity {

    RecyclerView recyclerView;
    PatientListAdaptor patientListAdaptor;
    List <Pationt>    pationtList =new ArrayList<>();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String TAG="----";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_patient);


        recyclerView =findViewById(R.id.listofpatient);
patientListAdaptor= new PatientListAdaptor(getApplicationContext(), pationtList, new CustomItemClickListener() {
    @Override
    public void OnItemClick(Pationt p) {



    }



});
        GridLayoutManager gridLayoutManager =new GridLayoutManager(getApplicationContext(),4);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(patientListAdaptor);
/*
Pationt p = new Pationt();
p.setPation_Name("Moooh");
pationtList.add(p);
patientListAdaptor.notifyDataSetChanged();
*/

                getpatient();

    }


    public void getpatient() {

        db.collection("patient")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful())
                        {
                            if (  task.getResult().isEmpty())
                                Log.d(TAG,"HHHHHHH");
                            Pationt p;
                            for (QueryDocumentSnapshot document : task.getResult())
                            {
                                Log.d(TAG, "======================>" + document.getId());
                                p= new Pationt();
                                p.setPation_Name(document.get("pname").toString());
                              /*  p.setPatientage(Integer.parseInt(document.get("age").toString()));
                                p.setPAddress(document.get("address").toString());
                                p.setPnationality(document.get("nationality").toString());
                                p.setEmrName(document.get("emr_name").toString());
                           */ //    p.setEmrNumber(Integer.parseInt(document.get("emr_number").toString()));

                                pationtList.add(p);
                                patientListAdaptor.notifyDataSetChanged();


                                //     String s  = document.get("").toString();
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "000000000000000000000000000Error getting documents.", task.getException());
                        }
                    }
                });




    }
}

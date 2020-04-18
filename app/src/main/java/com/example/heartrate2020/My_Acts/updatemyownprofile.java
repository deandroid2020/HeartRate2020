package com.example.heartrate2020.My_Acts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heartrate2020.R;
import com.example.heartrate2020.Session;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class updatemyownprofile extends AppCompatActivity {

    ImageView updateownprofile;
    TextView done,cnacel;
    EditText  pname , age , address , nationality,emername,emernumber;
    String DocId;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String mymesg;
    Session session;
    String TAG = "-------------";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatemyownprofile);




        updateownprofile=findViewById(R.id.updatemebtn);
        done=findViewById(R.id.itextdone);
        cnacel=findViewById(R.id.itextcancle);
        pname=findViewById(R.id.ieditTextpname);
        age=findViewById(R.id.ieditTextage);
        address=findViewById(R.id.ieditTextaddress);
        nationality=findViewById(R.id.ieditTextnatiunality);
        emername=findViewById(R.id.iemrname);
        emernumber=findViewById(R.id.iemrmobile);

        Intent intent= getIntent();




        DocId = intent.getStringExtra("DocId");
        pname.setText(intent.getStringExtra("pname"));
        age.setText(String.valueOf(intent.getIntExtra("Age",0)));
        address.setText(intent.getStringExtra("address"));
        nationality.setText(intent.getStringExtra("nationality"));
        emername.setText(intent.getStringExtra("emr_name"));
        emernumber.setText(String.valueOf(intent.getIntExtra("emr_number",0)));

//        Log.d("we got this",session.GetDacID());


        db.collection("patient").whereEqualTo("PId", "1000" ).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " =======> " + document.getData());

                            pname.setText(document.get("pname").toString());
                            age.setText(document.get("Age").toString());
                            address.setText(document.get("address").toString());
                            nationality.setText(document.get("nationali5ty").toString());
                            emername.setText(document.get("emr_name").toString());
                            emernumber.setText(document.get("emr_number").toString());



                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ffffffffffffff" , e.getMessage());
            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                        DocumentReference washingtonRef = db.collection("patient").document(session.GetDacID());

                        final Map<String, Object> data = new HashMap<>();
                        data.put("pname", pname.getText().toString().trim());
                        data.put("Age", age.getText().toString().trim());
                        data.put("address", address.getText().toString().trim());
                        data.put("nationali5ty", nationality.getText().toString().trim());
                        data.put("emr_name", emername.getText().toString().trim());
                        data.put("emr_number", emernumber.getText().toString().trim());

                        washingtonRef.update(data).addOnSuccessListener(new OnSuccessListener<Void>()
                        {
                            @Override
                            public void onSuccess(Void aVoid) {

                                Toast.makeText(getApplicationContext() , "Patent Data successfully updated!" , Toast.LENGTH_LONG).show();
                                mymesg="patent profile has been modfied";

                                startActivity(new Intent(getApplicationContext() , PatientPage.class));
/*
                        Notification notification= new Notification(emp_name.getText().toString().trim());

                        // Add a new document with a generated id.
                        Map<String, Object> data = new HashMap<>();
                        data.put("name", "Employee Profile Has Been Updated "+notification.getMsg());
                        data.put("date", notification.getDate());
                        data.put("time", notification.getTimenote());

                        db.collection("Updates").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                //          Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        //          Log.w(TAG, "Error adding document", e);
                                    }
                                });*/


                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        Toast.makeText(getApplicationContext() , "Error updating document "+e.toString() , Toast.LENGTH_LONG).show();
                                    }
                                });

                    }
                });//done is done






        updateownprofile.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    pname.setEnabled(false);
                                                    age.setEnabled(false);
                                                    address.setEnabled(true);
                                                    nationality.setEnabled(false);
                                                    emername.setEnabled(true);
                                                    emernumber.setEnabled(true);




                                                }

                                            }
        );


        cnacel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pname.setEnabled(false);
                age.setEnabled(false);
                address.setEnabled(false);
                nationality.setEnabled(false);
                emername.setEnabled(false);
                emernumber.setEnabled(false);


            }


    });

    }//end of OnCreate



    private String randomnumber()
    {
        int[] s = {new Random().nextInt(9), new Random().nextInt(9), new Random().nextInt(9), new Random().nextInt(9)};
        String t = "";
        for (int i = 0; i < s.length; i++) {
            t = t + s[i];
        }
        return t;
    }
}//end of updatemypown class




package com.example.heartrate2020.My_Acts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.heartrate2020.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PatientProfile extends AppCompatActivity {

  ImageView remove ,edit,reporticon;
    EditText /*id,*/ pname , age , address , nationality,emername,emernumber;
    TextView done,camcel;
    String DocId;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String mymesg;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientprofile);

        camcel=findViewById(R.id.textcancle);
        done =findViewById(R.id.textdone);
        pname=findViewById(R.id.editTextpname);
        age=findViewById(R.id.editTextage);
        address=findViewById(R.id.editTextaddress);
        nationality=findViewById(R.id.editTextnatiunality);
        emername=findViewById(R.id.emrname);
        emernumber=findViewById(R.id.emrmobile);
         remove = findViewById(R.id.premove);
         edit = findViewById(R.id.pedit);
         reporticon=findViewById(R.id.reporrrrticon);

        Intent intent = getIntent();



        DocId = intent.getStringExtra("DocId");
        pname.setText(intent.getStringExtra("pname"));
        age.setText(String.valueOf(intent.getIntExtra("Age",0)));
        address.setText(intent.getStringExtra("address"));
        nationality.setText(intent.getStringExtra("nationality"));
        emername.setText(intent.getStringExtra("emr_name"));
        emernumber.setText(String.valueOf(intent.getIntExtra("emr_number",0)));



        pname.setEnabled(false);
        age.setEnabled(false);
        address.setEnabled(false);
        nationality.setEnabled(false);
        emername.setEnabled(false);
        emernumber.setEnabled(false);

        // To Delete a patient
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.collection("patient").document(DocId).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Toast.makeText(getApplicationContext() , "Deleted" , Toast.LENGTH_LONG).show();

                       // Notification notification= new Notification(emp_name.getText().toString().trim());
/*
                        // Add a new document with a generated id.
                        Map<String, Object> data = new HashMap<>();
                        data.put("name", "patent Profile Has Been Removed "+notification.getMsg());
                        data.put("date", notification.getDate());
                        data.put("time", notification.getTimenote());
*/
                        Map<String, Object> data = new HashMap<>();

                        db.collection("patient").add(data).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
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
                                });

                        Intent intent = new Intent(getApplicationContext(), ManagePatient.class);
                        startActivity(intent);

                    }
                } );

            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DocumentReference washingtonRef = db.collection("patient").document(DocId);

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

                        startActivity(new Intent(getApplicationContext() , ManagePatient.class));
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


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pname.setEnabled(true);
                age.setEnabled(true);
                address.setEnabled(true);
                nationality.setEnabled(true);
                emername.setEnabled(true);
                emernumber.setEnabled(true);


            }

        }
        );


                camcel.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                pname.setEnabled(false);
                                                age.setEnabled(false);
                                                address.setEnabled(false);
                                                nationality.setEnabled(false);
                                                emername.setEnabled(false);
                                                emernumber.setEnabled(false);

                                            }
                                        }

                );


        reporticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), PReport.class);
                startActivity(intent);
            }
        });
    }
}

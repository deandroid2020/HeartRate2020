package com.example.heartrate2020.My_Acts;

import android.app.Notification;
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

    ImageView remove = findViewById(R.id.premove), edit;
    EditText id, pname , age , address , nationality,emername,emernumber;
    TextView done;
    String DocId;


    FirebaseFirestore db = FirebaseFirestore.getInstance();

    String mymesg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_detials);

        done =findViewById(R.id.textdone);
        pname=findViewById(R.id.editTextpname);
        age=findViewById(R.id.editTextage);
        address=findViewById(R.id.editTextaddress);
        nationality=findViewById(R.id.editTextnatiunality);
        emername=findViewById(R.id.emrname);
        emernumber=findViewById(R.id.emrmobile);
        edit=findViewById(R.id.pedit);

        Intent intent = getIntent();

        DocId = intent.getStringExtra("DocId");

        pname.setText(intent.getStringExtra("pname"));
        age.setText(intent.getStringExtra("age"));
        address.setText(intent.getStringExtra("address"));
        nationality.setText(intent.getStringExtra("nationality"));
        emername.setText(intent.getStringExtra("emr name"));
        emernumber.setText(intent.getStringExtra("emr number"));


        /*
        // To Delete An patient
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.collection("Patient").document(DocId).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Toast.makeText(getApplicationContext() , "Deleted" , Toast.LENGTH_LONG).show();

                        Notification notification= new Notification(emp_name.getText().toString().trim());

                        // Add a new document with a generated id.
                        Map<String, Object> data = new HashMap<>();
                        data.put("name", "patent Profile Has Been Removed "+notification.getMsg());
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
                                });

                        Intent intent = new Intent(getApplicationContext(), ManageEmployee.class);
                        startActivity(intent);

                    }
                });

            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DocumentReference washingtonRef = db.collection("Employee").document(DocId);

                final Map<String, Object> data = new HashMap<>();
                data.put("pname", .pname().toString().trim());
                data.put("Age", age.getText().toString().trim());
                data.put("address", address.getText().toString().trim());
                data.put("nationali5ty", nationality.getText().toString().trim());
                data.put("emr name", emername.getText().toString().trim());
                data.put("emr number", emernumber.getText().toString().trim());

                washingtonRef.update(data).addOnSuccessListener(new OnSuccessListener<Void>()
                {
                    @Override
                    public void onSuccess(Void aVoid) {

                        Toast.makeText(getApplicationContext() , "Employee Data successfully updated!" , Toast.LENGTH_LONG).show();
                        mymesg="paient profile has been modfied";

                        pname.setEnabled(false);
                        age.setEnabled(false);
                        address.setEnabled(false);
                        nationality.setEnabled(false);
                        emername.setEnabled(false);
                        emernumber.setEnabled(false);

                        Notification notification= new Notification(emp_name.getText().toString().trim());

                        // Add a new document with a generated id.
                        Map<String, Object> data = new HashMap<>();
                        data.put("name", "patient Profile Has Been Updated "+notification.getMsg());
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
                                });


                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(getApplicationContext() , "Error updating document "+e.toString() , Toast.LENGTH_LONG).show();
                            }
                        });

            }
        });


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
        });
*/
    }
}

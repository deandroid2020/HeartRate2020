package com.example.heartrate2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Pation_Profile extends AppCompatActivity {

    private ListView  listView ;
    private PationtListAdaptor pationtListAdaptor ;
    private List <Pationt> pationtList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pation__profile);


        pationtListAdaptor = new PationtListAdaptor(this,pationtList);

        listView = findViewById(R.id.palist);
        predata();
        listView.setAdapter(pationtListAdaptor);


    }
    private void predata()
    {

        for  (int  i =0 ; i<5; i++)
        {
            Pationt p = new Pationt();
            p.setPation_Name("Ahmad");
            p.setPationt_ID(i);

            pationtList.add(p);
        }
        pationtListAdaptor.notifyDataSetChanged();
    }

}

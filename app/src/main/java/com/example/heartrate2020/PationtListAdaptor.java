package com.example.heartrate2020;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class PationtListAdaptor extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List <Pationt> pationtItems ;

    public PationtListAdaptor(Activity activity, List<Pationt> pationtItems) {
        this.activity = activity;
        this.pationtItems = pationtItems;
    }

    @Override
    public int getCount() {
        return pationtItems.size();
    }

    @Override
    public Object getItem(int i) {
        return pationtItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (inflater == null )
        {
         inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view==null)
            view=inflater.inflate(R.layout.custome, null);

        TextView Pationt_Name = view.findViewById(R.id.PEName);
        TextView Pationt_ID = view.findViewById(R.id.PaID);

        final Pationt item = pationtItems.get(i);

        Pationt_Name.setText(item.getPation_Name());
        Pationt_ID.setText(String.valueOf(item.getPationt_ID()));


        return view;
    }
}

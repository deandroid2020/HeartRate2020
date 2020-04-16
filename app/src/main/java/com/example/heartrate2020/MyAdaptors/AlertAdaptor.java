package com.example.heartrate2020.MyAdaptors;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.heartrate2020.Model.Alert;
import com.example.heartrate2020.R;

import java.util.List;

public class AlertAdaptor extends BaseAdapter {

Activity activity;
LayoutInflater inflater;

List <Alert> listofalerts ;

    public AlertAdaptor(Activity activity, List<Alert> listofalerts) {
        this.activity = activity;
        this.listofalerts = listofalerts;
    }

    @Override
    public int getCount() {
        return listofalerts.size();
    }

    @Override
    public Object getItem(int position) {
        return listofalerts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        inflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.alertrow,null);

        TextView name =convertView.findViewById(R.id.rowname);
        TextView Hrate = convertView.findViewById(R.id.rowrate);
        TextView Rtime = convertView.findViewById(R.id.rowtime);

        name.setText(listofalerts.get(position).getName());
        Hrate.setText(listofalerts.get(position).getHrate());
        Rtime.setText(listofalerts.get(position).getTimealert());



        return convertView;
    }




}

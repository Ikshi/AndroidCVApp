package com.mobimove.createcv;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class CustomSecondary extends ArrayAdapter<Subject> {

    List<Subject> subjectList;

    CustomSecondary(Context context, List<Subject> subjectList) {
        super(context, R.layout.custom_row, subjectList);
        this.subjectList = subjectList;

    }

    @Override
    public int getCount() {
        return  subjectList.size();
    }

    @Override
    public Subject getItem(int position) {
        return subjectList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater Inflater = LayoutInflater.from(getContext());
        View customView = Inflater.inflate(R.layout.custom_row, parent, false);

        String result = getItem(position).subject;
        String subject = getItem(position).result;

        TextView txt_subject = (TextView) customView.findViewById(R.id.txt_subject);
        TextView txt_grade = (TextView) customView.findViewById(R.id.txt_grade);



        txt_grade.setText(result);
        txt_subject.setText(subject);


        return customView;
    }
}

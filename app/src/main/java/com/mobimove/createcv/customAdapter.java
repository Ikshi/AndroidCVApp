/**
 * Created by Dell on 8/16/2016.
 */
package com.mobimove.createcv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class customAdapter extends ArrayAdapter<List_First> {



    List<List_First> skillList;
    public customAdapter(Context context, List<List_First> skillList){
        super(context, R.layout.custom_row, skillList);
        this.skillList = skillList ;
    }

    @Override
    public int getCount(){
        return skillList.size();
    }

    @Override
    public List_First getItem(int position){
        return  skillList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater Inflater = LayoutInflater.from(getContext());
        View customView = Inflater.inflate(R.layout.custom_row,parent, false);

        String hobby = getItem(position).hobby;
        String percentage = getItem(position).percentage;

        TextView Txt_hobby = (TextView) customView.findViewById(R.id.txt_subject);
        TextView Txt_percentage = (TextView) customView.findViewById(R.id.txt_grade);

        Txt_hobby.setText(hobby);
        Txt_percentage.setText(percentage);




//        String singleSkill = getItem(position);
//        TextView Text =(TextView) customView.findViewById(R.id.txt_custom);
//
//        ImageView image = (ImageView) customView.findViewById(R.id.img_custom);
//
//        Text.setText(singleSkill);
//
//        image.setImageResource(R.drawable.playing);
        return customView;

    }
}

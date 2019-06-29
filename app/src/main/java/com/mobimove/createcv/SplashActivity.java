package com.mobimove.createcv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity {
    public static final String SAVED_DATA_KEY = "data_saved";
    Button create, edit;
    public final String MyPrefs = "details";
    public static final String PREFS = "details";
    Activity activity;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        create = (Button)findViewById(R.id.create);
        edit = (Button)findViewById(R.id.edit);
        activity = this;
    }

    public void moveToMainActivityCV(View view){
        Intent intent = new Intent(activity,MainActivityCV.class);
        activity.startActivity(intent);
    }



    public void moveToNextActivity(View view){
        sharedpreferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        Intent intent = new Intent(activity,MainActivityCV.class);

        boolean dataSaved = sharedpreferences.contains(SAVED_DATA_KEY);

        if (dataSaved && sharedpreferences.getBoolean(SAVED_DATA_KEY,false)){
            intent = new Intent(activity,FourthActivity.class);
        }
        activity.startActivity(intent);

    }
}

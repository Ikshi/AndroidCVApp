package com.mobimove.createcv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {

    public final String PREF_COLLEGE = "college";
    public final String PREF_SECONDARY = "secondary";
    public final String PREF_PRIMARY = "primary";
    public final String PREFS = SplashActivity.PREFS;

    EditText college, secondary, primary;
    Button btnOk;
    static Context activity;

    String collegeStr, secondaryStr, primaryStr, Education;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        college = (EditText) findViewById(R.id.college_text);

        secondary = (EditText) findViewById(R.id.secondary_text);
        primary = (EditText) findViewById(R.id.primary_text);
        btnOk = (Button) findViewById(R.id.btn);

        sharedpreferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE);

        String collegePref = sharedpreferences.getString(PREF_COLLEGE, "defValue");
        String secondaryPref = sharedpreferences.getString(PREF_SECONDARY, "defValue");
        String primaryPref = sharedpreferences.getString(PREF_PRIMARY, "defValue");

        if (!collegePref.equals("") || !collegePref.equals("defValue"))
            college.setText(collegePref);
        if (!secondaryPref.equals("") || !secondaryPref.equals("defValue"))
            secondary.setText(secondaryPref);
        if (!primaryPref.equals("") || !primaryPref.equals("defValue"))
            primary.setText(primaryPref);


        activity = this;

    }

    public void moveToThirdActivity(View view) {


        collegeStr = college.getText().toString();
        secondaryStr = secondary.getText().toString();
        primaryStr = primary.getText().toString();

        Details details = Details.getInstance();
        details.setCollege(collegeStr);
        details.setSecondary(secondaryStr);
        details.setPrimary(primaryStr);


        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(PREF_COLLEGE, collegeStr);
        editor.putString(PREF_SECONDARY, secondaryStr);
        editor.putString(PREF_PRIMARY, primaryStr);
        editor.commit();

        Intent intent = new Intent(this, ThirdActivity.class);
        activity.startActivity(intent);


    }


}

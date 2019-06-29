package com.mobimove.createcv;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    public final String PREF_FIRST = "first";
    public  final String PREF_SECOND = "second";
    public final String PREF_THIRD = "third";
public  final  String SAVED = SplashActivity.SAVED_DATA_KEY;
    EditText first,second,third;
    Button btnOk;
    static Context activity;

    String firstStr, secondStr, thirdStr;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        first = (EditText) findViewById(R.id.first);
        second = (EditText) findViewById(R.id.second);
        third = (EditText) findViewById(R.id.third);
        btnOk = (Button) findViewById(R.id.btn);

        activity = this;
        sharedpreferences = getSharedPreferences(SplashActivity.PREFS, Context.MODE_PRIVATE);

        String firstPref = sharedpreferences.getString(PREF_FIRST,"defValue");
        String secondPref = sharedpreferences.getString(PREF_SECOND,"defValue");
        String thirdPref = sharedpreferences.getString(PREF_THIRD,"defValue");

        if (!firstPref.equals("") || !firstPref.equals("defValue"))
            first.setText(firstPref);
        if (!secondPref.equals("") || !secondPref.equals("defValue"))
            second.setText(secondPref);
        if (!thirdPref.equals("") || !thirdPref.equals("defValue"))
            third.setText(thirdPref);



    }
    public void moveToFourthActivity(View view){
        firstStr = first.getText().toString();
        secondStr = second.getText().toString();
        thirdStr = third.getText().toString();



        Details details = Details.getInstance();
        details.setFirst(firstStr);
        details.setSecond(secondStr);
        details.setThird(thirdStr);



        Intent intent = new Intent(this, FourthActivity.class );
        activity.startActivity(intent);




        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString(PREF_FIRST, firstStr);
        editor.putString(PREF_SECOND, secondStr);
        editor.putBoolean(SAVED,true);
        editor.putString(PREF_THIRD, thirdStr);
        editor.commit();

    }

}

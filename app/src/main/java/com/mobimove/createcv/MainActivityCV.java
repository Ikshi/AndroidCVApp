package com.mobimove.createcv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityCV extends Activity {

    public final String PREF_NAME = "name";
    public final String PREF_EMAIL = "email";
    public final String PREF_PHONE = "PHONE";
    public final String PREF_ADDRESS = "address";
    public final String PREF_DOB = "dob";
    public final String PREFS = SplashActivity.PREFS;



    EditText email,phone,name,address, DOB;
    Button btnOk;
   static Context activity;

    String emailStr,phoneStr,nameStr,addressStr, DOBStr;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_cv);
        name = (EditText) findViewById(R.id.EditText_name);
        email = (EditText) findViewById(R.id.Email);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.EditText1);
        DOB = (EditText) findViewById(R.id.DOB);
        btnOk = (Button) findViewById(R.id.btn);
        activity = this;
        sharedpreferences = getSharedPreferences(SplashActivity.PREFS, Context.MODE_PRIVATE);
//        TODO ikshita

        String namePref = sharedpreferences.getString(PREF_NAME,"defValue");
        boolean isPersonal = sharedpreferences.getBoolean("isPersonal",false);
        String emailPref= sharedpreferences.getString(PREF_EMAIL,"defValue");
        String phonePref= sharedpreferences.getString(PREF_PHONE,"defValue");
        String addressPref= sharedpreferences.getString(PREF_ADDRESS,"defValue");
        String DOBPref = sharedpreferences.getString(PREF_DOB,"defValue");




        if (!namePref.equals("") || !namePref.equals("defValue"))
            name.setText(namePref);
        if (!emailPref.equals("") || !emailPref.equals("defValue"))
            email.setText(emailPref);
        if (!phonePref.equals("") || !phonePref.equals("defValue"))
            phone.setText(phonePref);
        if (!addressPref.equals("") || !addressPref.equals("defValue"))
            address.setText(addressPref);
        if (!DOBPref.equals("") || !DOBPref.equals("defValue"))
            DOB.setText(DOBPref);



        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    moveToSecondActivity();


            }
        });

    }






   private    void moveToSecondActivity(){

       emailStr = email.getText().toString();
       phoneStr = phone.getText().toString();
       nameStr = name.getText().toString();
       addressStr = address.getText().toString();
       DOBStr = DOB.getText().toString();

       Details details =Details.getInstance();
       details.setName(nameStr);
       details.setEmail(emailStr);
       details.setPhone(phoneStr);
       details.setAddress(addressStr);
       details.setDOB(DOBStr);

       SharedPreferences.Editor editor = sharedpreferences.edit();
       editor.putString(PREF_NAME, nameStr);
       editor.putString(PREF_EMAIL,emailStr);
       editor.putString(PREF_PHONE,phoneStr);
       editor.putString(PREF_ADDRESS,addressStr);
       editor.putString(PREF_DOB,DOBStr);
       editor.putBoolean("isPersonal",true);
       editor.commit();

       Intent intent = new Intent(activity,SecondActivity.class);

       activity.startActivity(intent);
    }

}

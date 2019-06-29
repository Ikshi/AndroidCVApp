package com.mobimove.createcv;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FourthActivity extends AppCompatActivity {
    TextView name, dob, email, phone, address, college, secondary, primary, first, second, third;
    EditText edtName, edtDob, edtEmail, edtphone, edtaddress, edtCollege, edtSecondary, edtPrimary, edtFirst, edtSecond, edtThird;
    ImageView imgEdtName, imgEdtDob, imgEdtEmail, imgEdtphone, imgEdtaddress, imgEdtCollege, imgEdtSecondary, imgEdtPrimary, imgEdtFirst, imgEdtSecond, imgEdtThird;
    ListView listView, listViewFirst, listSecondary;

    public final String PREF_NAME = "name";
    public final String PREF_EMAIL = "email";
    public final String PREF_PHONE = "PHONE";
    public final String PREF_ADDRESS = "address";
    public final String PREF_DOB = "dob";
    public final String PREF_COLLEGE = "college";
    public final String PREF_SECONDARY = "secondary";
    public final String PREF_PRIMARY = "primary";
    public final String PREF_FIRST = "first";
    public final String PREF_SECOND = "second";
    public final String PREF_THIRD = "third";
    Context context;


    String nameStr, dobStr, emailStr, phoneStr, addressStr, collegeStr, secondaryStr, primaryStr, firstStr, secondStr, thirdStr;
    String[] resultArray = {"English", "French", "Maths"};
    String[] firstArray = {"drawing", "Reading", "Painting"};
    ArrayList<Subject> subjectList;
    ArrayList<List_First> skillList;

    String[] SecondaryResult = {"56", "70", "100"};

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        name = (TextView) findViewById(R.id.name);
        dob = (TextView) findViewById(R.id.DOB);
        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.phone);
        address = (TextView) findViewById(R.id.address);
        college = (TextView) findViewById(R.id.college);
        secondary = (TextView) findViewById(R.id.secondary);
        primary = (TextView) findViewById(R.id.primary);
        first = (TextView) findViewById(R.id.first);
        second = (TextView) findViewById(R.id.second);
        third = (TextView) findViewById(R.id.third);
        edtName = (EditText) findViewById(R.id.editText_name);
        imgEdtName = (ImageView) findViewById(R.id.img_edt_name);
        edtDob = (EditText) findViewById(R.id.editText_dob);
        imgEdtDob = (ImageView) findViewById(R.id.img_edt_dob);
        edtEmail = (EditText) findViewById(R.id.editText_email);
        imgEdtEmail = (ImageView) findViewById(R.id.img_edt_email);
        edtphone = (EditText) findViewById(R.id.edt_phone);
        imgEdtphone = (ImageView) findViewById(R.id.img_edt_phone);
        edtaddress = (EditText) findViewById(R.id.edt_address);
        imgEdtaddress = (ImageView) findViewById(R.id.img_edt_address);
        edtCollege = (EditText) findViewById(R.id.edt_college);
        imgEdtCollege = (ImageView) findViewById(R.id.img_edt_college);
        edtSecondary = (EditText) findViewById(R.id.edt_secondary);
        imgEdtSecondary = (ImageView) findViewById(R.id.img_edt_secondary);
        edtPrimary = (EditText) findViewById(R.id.edt_primary);
        imgEdtPrimary = (ImageView) findViewById(R.id.img_edt_primary);
        edtFirst = (EditText) findViewById(R.id.edt_first);
        imgEdtFirst = (ImageView) findViewById(R.id.img_edt_first);
        edtSecond = (EditText) findViewById(R.id.edt_second);
        imgEdtSecond = (ImageView) findViewById(R.id.img_edt_second);
        edtThird = (EditText) findViewById(R.id.edt_third);
        imgEdtThird = (ImageView) findViewById(R.id.img_edt_third);
        listView = (ListView) findViewById(R.id.list_primary);
        listViewFirst = (ListView) findViewById(R.id.list_first);
        listSecondary = (ListView) findViewById(R.id.list_secondary);


        subjectList = new ArrayList<>();
        subjectList.add(new Subject("A", "French"));
        subjectList.add(new Subject("B", "English"));
        subjectList.add(new Subject("C", "Maths"));

        skillList = new ArrayList<>();
        skillList.add(new List_First("Drawing", "50"));
        skillList.add(new List_First("Writing", "80"));
        skillList.add(new List_First("reading", "100"));


        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_list_view, resultArray);

        primary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listView.getVisibility() == View.VISIBLE)
                    listView.setVisibility(View.GONE);
                else {
                    listView.setVisibility(View.VISIBLE);
                }
            }
        });


        listView.setAdapter(adapter);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listViewFirst.getVisibility() == View.VISIBLE)
                    listViewFirst.setVisibility(View.GONE);
                else {
                    listViewFirst.setVisibility(View.VISIBLE);
                }
            }
        });

        ListAdapter Adapter = new com.mobimove.createcv.customAdapter(this, skillList);
        listViewFirst.setAdapter(Adapter);

        secondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listSecondary.getVisibility() == View.VISIBLE)
                    listSecondary.setVisibility(View.GONE);
                else {
                    listSecondary.setVisibility(View.VISIBLE);
                }
            }
        });

        ListAdapter list = new CustomSecondary(this, subjectList);


        listSecondary.setAdapter(list);


        sharedpreferences = getSharedPreferences(SplashActivity.PREFS, Context.MODE_PRIVATE);


        getDetails();


    }



    public void editName(View view) {

        if (name.getVisibility() == View.VISIBLE) {
            name.setVisibility(View.GONE);
            edtName.setVisibility(View.VISIBLE);
            imgEdtName.setImageResource(R.drawable.tick);

            edtName.setText(name.getText().toString());


        } else {
            name.setVisibility(View.VISIBLE);
            name.setText(edtName.getText().toString());
            imgEdtName.setImageResource(R.drawable.pencil);
            edtName.setVisibility(View.GONE);
            nameStr = name.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(PREF_NAME, nameStr);
            editor.commit();

        }
    }

    public void editDOB(View view) {
        if (dob.getVisibility() == View.VISIBLE) {
            dob.setVisibility(View.GONE);
            edtDob.setVisibility(View.VISIBLE);
            imgEdtDob.setImageResource(R.drawable.tick);
            edtDob.setText(dob.getText().toString());

        } else {
            dob.setVisibility(View.VISIBLE);
            dob.setText(edtDob.getText().toString());
            imgEdtDob.setImageResource(R.drawable.pencil);
            edtDob.setVisibility(View.GONE);
            dobStr = dob.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(PREF_DOB, dobStr);
            editor.commit();
        }
    }

    public void editEmail(View view) {
        if (email.getVisibility() == View.VISIBLE) {
            email.setVisibility(View.GONE);
            edtEmail.setVisibility(View.VISIBLE);
            imgEdtEmail.setImageResource(R.drawable.tick);
            edtEmail.setText(email.getText().toString());
        } else {
            email.setVisibility(View.VISIBLE);
            email.setText(edtEmail.getText().toString());
            imgEdtEmail.setImageResource(R.drawable.pencil);
            edtEmail.setVisibility(View.GONE);
            emailStr = email.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(PREF_EMAIL, emailStr);
            editor.commit();
        }
    }

    public void editPhone(View view) {
        if (phone.getVisibility() == View.VISIBLE) {
            phone.setVisibility(View.GONE);
            edtphone.setVisibility(View.VISIBLE);
            imgEdtphone.setImageResource(R.drawable.tick);
            edtphone.setText(phone.getText().toString());
        } else {
            phone.setVisibility(View.VISIBLE);
            phone.setText(edtphone.getText().toString());
            imgEdtphone.setImageResource(R.drawable.pencil);
            edtphone.setVisibility(View.GONE);
            phoneStr = phone.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(PREF_PHONE, phoneStr);
            editor.commit();
        }
    }

    public void editAddress(View view) {
        if (address.getVisibility() == View.VISIBLE) {
            address.setVisibility(View.GONE);
            edtaddress.setVisibility(View.VISIBLE);
            imgEdtaddress.setImageResource(R.drawable.tick);
            edtaddress.setText(address.getText().toString());
        } else {
            address.setVisibility(View.VISIBLE);
            address.setText(edtaddress.getText().toString());
            imgEdtaddress.setImageResource(R.drawable.pencil);
            edtaddress.setVisibility(View.GONE);
            addressStr = address.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(PREF_ADDRESS, addressStr);
            editor.commit();
        }
    }

    public void editCollege(View view) {
        if (college.getVisibility() == View.VISIBLE) {
            college.setVisibility(View.GONE);
            edtCollege.setVisibility(View.VISIBLE);
            imgEdtCollege.setImageResource(R.drawable.tick);
            edtCollege.setText(college.getText().toString());
        } else {
            college.setVisibility(View.VISIBLE);
            college.setText(edtCollege.getText().toString());
            imgEdtCollege.setImageResource(R.drawable.pencil);
            edtCollege.setVisibility(View.GONE);
            collegeStr = college.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(PREF_COLLEGE, collegeStr);
            editor.commit();
        }
    }

    public void editSecondary(View view) {
        if (secondary.getVisibility() == View.VISIBLE) {
            secondary.setVisibility(View.GONE);
            edtSecondary.setVisibility(View.VISIBLE);
            imgEdtSecondary.setImageResource(R.drawable.tick);
            edtSecondary.setText(secondary.getText().toString());
        } else {
            secondary.setVisibility(View.VISIBLE);
            secondary.setText(edtSecondary.getText().toString());
            imgEdtSecondary.setImageResource(R.drawable.pencil);
            edtSecondary.setVisibility(View.GONE);
            secondaryStr = secondary.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(PREF_SECONDARY, secondaryStr);
            editor.commit();
        }
    }

    public void editPrimary(View view) {
        if (primary.getVisibility() == View.VISIBLE) {
            primary.setVisibility(View.GONE);
            edtPrimary.setVisibility(View.VISIBLE);
            imgEdtPrimary.setImageResource(R.drawable.tick);
            edtPrimary.setText(primary.getText().toString());
        } else {
            primary.setVisibility(View.VISIBLE);
            primary.setText(edtPrimary.getText().toString());
            imgEdtPrimary.setImageResource(R.drawable.pencil);
            edtPrimary.setVisibility(View.GONE);
            primaryStr = primary.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(PREF_PRIMARY, primaryStr);
            editor.commit();
        }
    }

    public void editFirst(View view) {
        if (first.getVisibility() == View.VISIBLE) {
            first.setVisibility(View.GONE);
            edtFirst.setVisibility(View.VISIBLE);
            imgEdtFirst.setImageResource(R.drawable.tick);
            edtFirst.setText(first.getText().toString());
        } else {
            first.setVisibility(View.VISIBLE);
            first.setText(edtFirst.getText().toString());
            imgEdtFirst.setImageResource(R.drawable.pencil);
            edtFirst.setVisibility(View.GONE);
            firstStr = first.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(PREF_FIRST, firstStr);
            editor.commit();
        }
    }

    public void editSecond(View view) {
        if (second.getVisibility() == View.VISIBLE) {
            second.setVisibility(View.GONE);
            edtSecond.setVisibility(View.VISIBLE);
            imgEdtSecond.setImageResource(R.drawable.tick);
            edtSecond.setText(second.getText().toString());
        } else {
            second.setVisibility(View.VISIBLE);
            second.setText(edtSecond.getText().toString());
            imgEdtSecond.setImageResource(R.drawable.pencil);
            edtSecond.setVisibility(View.GONE);
            secondStr = second.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(PREF_SECOND, secondStr);
            editor.commit();
        }
    }

    public void editThird(View view) {
        if (third.getVisibility() == View.VISIBLE) {
            third.setVisibility(View.GONE);
            edtThird.setVisibility(View.VISIBLE);
            imgEdtThird.setImageResource(R.drawable.tick);
            edtThird.setText(third.getText().toString());
        } else {
            third.setVisibility(View.VISIBLE);
            third.setText(edtThird.getText().toString());
            imgEdtThird.setImageResource(R.drawable.pencil);
            edtThird.setVisibility(View.GONE);
            thirdStr = third.getText().toString();
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(PREF_THIRD, thirdStr);
            editor.commit();
        }
    }



    private void getDetails() {


        String name = sharedpreferences.getString(PREF_NAME, "");
        String dob = sharedpreferences.getString(PREF_DOB, "");
        String email = sharedpreferences.getString(PREF_EMAIL, "");
        String phone = sharedpreferences.getString(PREF_PHONE, "");
        String address = sharedpreferences.getString(PREF_ADDRESS, "");
        String college = sharedpreferences.getString(PREF_COLLEGE, "");
        String secondary = sharedpreferences.getString(PREF_SECONDARY, "");
        String primary = sharedpreferences.getString(PREF_PRIMARY, "");
        String first = sharedpreferences.getString(PREF_FIRST, "");
        String second = sharedpreferences.getString(PREF_SECOND, "");
        String third = sharedpreferences.getString(PREF_THIRD, "");

        this.name.setText(name);
        this.dob.setText(dob);
        this.email.setText(email);
        this.phone.setText(phone);
        this.address.setText(address);
        this.college.setText(college);
        this.secondary.setText(secondary);
        this.primary.setText(primary);
        this.first.setText(first);
        this.second.setText(second);
        this.third.setText(third);
    }


}

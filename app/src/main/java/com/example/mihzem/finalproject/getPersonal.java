package com.example.mihzem.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class getPersonal extends AppCompatActivity {
    // public boolean ismale;
    RadioGroup rglifestyle, rgsex;
    RadioButton male_btn, female_btn, veryActive_btn, modActive_btn, sedentary_btn;
    Button submit_button, cbutton;
    //EditText getWeight, getAge, getFeet, getInches;
    EditText weight_et, feet_et, inches_et, age_et;
    TextView tvWeight, tvSex, tvHeight, tvAge, tvLifeStyle;
    TextView tvgoalLoss, finalcal, oneelb, twoolb;
    public static String gender = " ";
    public static String lifestyle = " ";
    double weight = 0;
    double feet = 0;
    double addition = 0;
    double inches =0;
    double result = 0;
    double age = 0;
    double centimeters = 0;
    double weight2 = 0;
    int result3 = 0;
    double withlifestyle = 0;
    int lsresult = 0;
    double multip =0;
    int onelb = 0;
    int twolb = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_personal);

// after user provides these personal pieces of information,
        // data will be saved and put into a calculation later
        weight_et = (EditText) findViewById(R.id.weight_et);
        feet_et = (EditText) findViewById(R.id.feet_et);
        inches_et = (EditText) findViewById(R.id.inches_et);
        age_et = (EditText) findViewById(R.id.age_et);

        tvgoalLoss = (TextView) findViewById(R.id.toLose_tv);
        tvWeight = (TextView) findViewById(R.id.weight_tv);
        tvSex = (TextView) findViewById(R.id.sex_tv);
        tvHeight = (TextView) findViewById(R.id.height_tv);
        tvAge = (TextView) findViewById(R.id.age_tv);
        tvLifeStyle = (TextView) findViewById(R.id.lifestyle_tv);

        finalcal = (TextView) findViewById(R.id.textView2);

        oneelb = (TextView) findViewById(R.id.textView9);
        twoolb = (TextView)  findViewById(R.id.textView10);

        rglifestyle = (RadioGroup) findViewById(R.id.radioGroup2);
        rgsex = (RadioGroup) findViewById(R.id.radioGroup);
        initRadioGroup1();
        initRadioGroup2();
        initButton();

    }



    public void onClick(View typedData){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;


        switch (typedData.getId()){
            case R.id.submit_button:


        }
    }

    public void initRadioGroup1() {
        RadioGroup rgsex = (RadioGroup) findViewById(R.id.radioGroup);
        rgsex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedID) {

                RadioButton male_btn = (RadioButton) findViewById(R.id.male_rb);
                RadioButton female_btn = (RadioButton) findViewById(R.id.female_rb);

                if (male_btn.isChecked() == true) {
                    gender = "male";
                    addition = 5;
                }
                if (female_btn.isChecked() == true) {
                    gender = "female";
                    addition = -161;
                }
            }
        });
    }

    public void initRadioGroup2(){
        RadioGroup rglifestyle = (RadioGroup) findViewById(R.id.radioGroup2);
        rglifestyle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //@Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
// initialize the three activity level buttons
                RadioButton veryActive_btn = (RadioButton) findViewById(R.id.veryActive_rb);
                RadioButton modActive_btn = (RadioButton) findViewById(R.id.modActive_rb);
                RadioButton sedentary_btn = (RadioButton) findViewById(R.id.sedentary_rb);

                if (veryActive_btn.isChecked() == true){
                    lifestyle = "very active";
                    multip = 1.725;
                }
                if (modActive_btn.isChecked() == true){
                    lifestyle = "mod active";
                    multip = 1.55;
                }
                if (sedentary_btn.isChecked() == true){
                    lifestyle = "sedentary";
                    multip = 1.2;
                }
            }
        });
    }

    //buttons
    private void initButton(){
        submit_button = (Button) findViewById(R.id.submit_button);
        cbutton = (Button) findViewById(R.id.cbutton);
        //clickers:
        submit_button.setOnClickListener(new ButtonListener());
        cbutton.setOnClickListener(new ButtonListener());

    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v){
            weight = Integer.parseInt(weight_et.getText().toString());
            feet = Integer.parseInt(feet_et.getText().toString());
            inches = Integer.parseInt(inches_et.getText().toString());
            age = Integer.parseInt(age_et.getText().toString());

            switch (v.getId()){

                case R.id.submit_button:
                    //
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;

                    if ( TextUtils.isEmpty(weight_et.getText().toString()) || TextUtils.isEmpty(feet_et.getText().toString()) || TextUtils.isEmpty(inches_et.getText().toString()) || TextUtils.isEmpty(age_et.getText().toString())) {
                        CharSequence text = "oops, bad inputs";
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        return;
                    }
                    centimeters = (2.54 * inches) + (30.48 * feet);
                    weight2 = (weight * .454);
                    result = (10 * weight2) + (6.25* centimeters) - (5 * age) + addition;
                    int result3 = (int) result;
                    tvgoalLoss.setText("BMR:" + Integer.toString(result3));

// following are the equations for BMR and BMI
                    withlifestyle = (result * multip);
                    int lsresult = (int) withlifestyle;
                    finalcal.setText("Stay Below:" + Integer.toString(lsresult));

                    onelb = lsresult - 500;
                    oneelb.setText("To lose 1 lb a week:" + Integer.toString(onelb));

                    twolb = lsresult - 1000;
                    twoolb.setText("To lose 2 lbs a week:" + Integer.toString(twolb));



                    break;
                case R.id.cbutton:
                    weight_et.setText("");
                    age_et.setText("");
                    inches_et.setText("");
                    feet_et.setText("");
                    rglifestyle.clearCheck();
                    rgsex.clearCheck();
                    tvgoalLoss.setText("BMR:");
                    finalcal.setText("With lifestyle:");
                    oneelb.setText("To lose 1 pound a week");
                    twoolb.setText("To lose 2 pounds a week");

                    if ( TextUtils.isEmpty(weight_et.getText().toString()) ||
                            TextUtils.isEmpty(feet_et.getText().toString()) ||
                            TextUtils.isEmpty(inches_et.getText().toString()) ||
                            TextUtils.isEmpty(age_et.getText().toString())) {
                        Toast.makeText(getPersonal.this, "enter something! nothing to clear", Toast.LENGTH_SHORT).show();

                        break;

                    }
                        break;
            }
        }

    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

}



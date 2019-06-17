package com.example.mihzem.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton btnpersonal, btnfood, btnsleep, btnworkouts;
// main page with the four activity buttons
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnpersonal = (ImageButton) findViewById(R.id.personal_button);
        btnfood = (ImageButton) findViewById(R.id.food_button);
        btnsleep = (ImageButton) findViewById(R.id.sleep_button);
        btnworkouts = (ImageButton) findViewById(R.id.workout_button);

        btnpersonal.setOnClickListener(new Clicker1());
        btnfood.setOnClickListener(new Clicker1());
        btnsleep.setOnClickListener(new Clicker1());
        btnworkouts.setOnClickListener(new Clicker1());

    }
    private class Clicker1 implements View.OnClickListener{
        public void onClick(View v){
            Bundle myData;
            switch (v.getId()){
                case R.id.personal_button:
                    //intent
                    Intent myPersonalIntent = new Intent(MainActivity.this, getPersonal.class);
                    myData = new Bundle();
                    myData.putInt("myRequestCode", 101);
                    startActivityForResult(myPersonalIntent, 101);
                    break;
                case R.id.food_button:
                    Intent myFoodIntent = new Intent(MainActivity.this, getFood.class);
                    myData = new Bundle();
                    myData.putInt("myRequestCode", 102);
                    startActivityForResult(myFoodIntent, 102);
                    break;
                case R.id.sleep_button:
                    Intent mySleepIntent = new Intent(MainActivity.this, getSleep.class);
                    myData = new Bundle();
                    myData.putInt("myRequestCode", 103);
                    startActivityForResult(mySleepIntent, 103);
                    break;
                case R.id.workout_button:
                    Intent myWorkoutIntent = new Intent(MainActivity.this, getWorkouts.class);
                    myData = new Bundle();
                    myData.putInt("myRequestCode", 104);
                    startActivityForResult(myWorkoutIntent, 104);
                    break;
            }
        }// on click
    }// clicker1

    // local listener receiving callbacks from other activities
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 101) && (resultCode == Activity.RESULT_OK)) {
            Bundle myResults = data.getExtras();
        }
        if ((requestCode == 102) && (resultCode == Activity.RESULT_OK)) {
            Bundle myResults = data.getExtras();
        }
        if ((requestCode == 103) && (resultCode == Activity.RESULT_OK)) {
            Bundle myResults = data.getExtras();
        }
        if ((requestCode == 104) && (resultCode == Activity.RESULT_OK)) {
            Bundle myResults = data.getExtras();
        }

        }
    }


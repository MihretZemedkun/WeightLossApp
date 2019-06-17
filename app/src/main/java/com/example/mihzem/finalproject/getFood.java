package com.example.mihzem.finalproject;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.*;

import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;


import java.util.ArrayList;

public class getFood extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    private static String[] items;
    Button add_button;
    EditText search_et;
    String phrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_food);
        Resources res = getResources();
        items = res.getStringArray(R.array.items);
        add_button = (Button) findViewById(R.id.add_button);
        search_et = (EditText) findViewById(R.id.search_et);

        // data to populate the RecyclerView with

        final ArrayList<String> cookingSites = new ArrayList<>();
        int c = items.length;
        for (int i = 0; i<c; i++)
            cookingSites.add(items[i]);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.cookingSites);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, cookingSites);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        add_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                phrase = (search_et.getText().toString());

                if (search_et.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter a task!", Toast.LENGTH_SHORT).show();
                } else {
                    //  String phrase = new String(search_et.getText().toString(), false);
                    cookingSites.add(phrase);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(),
                            "New task: \n" + search_et.getText().toString(), Toast.LENGTH_SHORT).show();
                    search_et.setText("");
                }
            }
        });


    }
    //each time you type in and click a food item to look up,
    //this activity creates the intent from the page to the recipe website

    @Override
    public void onItemClick(View view, int position) {
        final Intent intent1;
       // Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        String phrase = ("http://www.eatingwell.com/search/results/?wt="+ adapter.getItem(position)+"&sort=re");
        intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(phrase));
        startActivity(intent1);
    }

}

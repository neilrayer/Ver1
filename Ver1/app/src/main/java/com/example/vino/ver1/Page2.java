package com.example.vino.ver1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

import static com.example.vino.ver1.R.id.expandableListView1;

public class Page2 extends AppCompatActivity {
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> list;
    private HashMap<String, List<String>> listHashMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        listView = (ExpandableListView) findViewById(R.id.expandableListView1);


        initData();
        listAdapter = new Adapter(this, list, listHashMap);
        listView.setAdapter(listAdapter);

        listView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int i, int i2, long id) {

                 final String string=listHashMap.get(list.get(i)).get(i2);
                Intent intent;
                switch(string) {
                    case "Android":
                        intent = new Intent(Page2.this, Android.class);
                        startActivity(intent);
                        break;
                    case "Kotlin":
                        intent = new Intent(Page2.this, Kotlin.class);
                        startActivity(intent);
                        break;
                    case "Objective C":
                        intent = new Intent(Page2.this, Objective.class);
                        startActivity(intent);
                        break;
                    case "Swift":
                        intent = new Intent(Page2.this, Swift.class);
                        startActivity(intent);
                        break;

                }
                return true;
            }
        });


    }


    private void initData() {
        list = new ArrayList<>();
        listHashMap = new HashMap<>();

        list.add("Java");

        list.add("Ios");


        List<String> java = new ArrayList<>();
        java.add("Android");
        java.add("Kotlin");


        List<String> ios = new ArrayList<>();
        ios.add("Swift");
        ios.add("Objective C");

        listHashMap.put(list.get(0), java);

        listHashMap.put(list.get(1), ios);


    }
}



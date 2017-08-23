package com.example.vino.ver1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    private HashMap<String,List<String>> listHashMap;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

         listView=(ExpandableListView)findViewById(R.id.expandableListView1);
         initData();
         listAdapter =new Adapter(this,list,listHashMap);
         listView.setAdapter(listAdapter);
     }

    private void initData() {
        list=new ArrayList<>();
        listHashMap=new HashMap<>();

        list.add("Java");
        list.add("Android");
        list.add("Swift");
        list.add("Ios");
        list.add("Kotlin");

        List<String> java=new ArrayList<>();
        java.add("this is Java");

        List<String> android=new ArrayList<>();
        android.add("this is Android");

        List<String> swift=new ArrayList<>();
        swift.add("This is Swift");

        List<String> ios=new ArrayList<>();
        ios.add("This is Ios");

        List<String> kotlin=new ArrayList<>();
        kotlin.add("This is Kotlin");

        listHashMap.put(list.get(0),java);
        listHashMap.put(list.get(1),android);
        listHashMap.put(list.get(2),swift);
        listHashMap.put(list.get(3),ios);
        listHashMap.put(list.get(4),kotlin);


    }

}

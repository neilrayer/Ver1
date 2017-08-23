package com.example.vino.ver1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.vino.ver1.R.id.dbtxtVeiw;
import static com.example.vino.ver1.R.id.txtChild;

public class Adapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> list;
    private HashMap<String,List<String>>   listHashMap;

    public Adapter(Context context, List<String> list, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.list = list;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {

        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {

        return listHashMap.get(list.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {

        return list.get(i);
    }

    @Override
    public Object getChild(int i, int i1)
    {

        return listHashMap.get(list.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i)
    {

        return i;
    }

    @Override
    public long getChildId(int i, int i1) {

        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title=(String)getGroup(i);
        if(view ==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(R.layout.db,null);
        }
        TextView listHead= (TextView)view.findViewById(R.id.dbtxtVeiw);
        ImageView img= (ImageView)view.findViewById(R.id.img) ;
        listHead.setText(title);

        if(title=="Java")
        {
            img.setImageResource(R.drawable.java);
        }else if(title=="Android")
        {
            img.setImageResource(R.drawable.android);
        }else if(title=="Ios")
        {
            img.setImageResource(R.drawable.apple);
        }else if(title=="Swift")
        {
            img.setImageResource(R.drawable.hai);
        }else if(title=="Kotlin")
        {
            img.setImageResource(R.drawable.kotlin);
        }

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup)
    {

        final String childText =(String)getChild(i,i1);
        if(view==null)
        {
            LayoutInflater inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.content,null);
        }
        TextView txtListChild =(TextView)view.findViewById(R.id.txtChild);
        txtListChild.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {

        return true;
    }
}
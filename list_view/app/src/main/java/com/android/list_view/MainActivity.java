package com.android.list_view;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class MainActivity extends Activity {


    String[]  names = {"Sam", "Son", "Sarath", "Gp", "Bk"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.list_view, names);

        ListView listView = (ListView) findViewById(R.id.names_list);
        listView.setAdapter(adapter);
    }
}
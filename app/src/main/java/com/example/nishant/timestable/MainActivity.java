package com.example.nishant.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar myseekBar;
    ListView myListView;


    public void createView(int timesTable) {
        ArrayList<String> timesTableContents = new ArrayList<String>();
        for(int i = 1 ; i <= 10 ; i++) {
            timesTableContents.add(timesTable + " * " + i + " = " + i * timesTable);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContents);
        myListView.setAdapter(arrayAdapter);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ListView myListView = (ListView) findViewById(R.id.myListView);
        final ArrayList<String> myFriends = new ArrayList<String>();
        myFriends.add("Rahul");
        myFriends.add("Ben");
        myFriends.add("Jeff");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);
        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(), "Hello " + myFriends.get(i), Toast.LENGTH_LONG).show();
            }
        });*/

         myseekBar = (SeekBar) findViewById(R.id.timesTableSeekBar);
         myListView = (ListView) findViewById(R.id.timesListView);

        myseekBar.setMax(50);
        myseekBar.setProgress(10);
        createView(10);


        myseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int min = 1;
                int timestable;
                if(progress < min) {
                     seekBar.setProgress(min);
                     timestable = min;
                } else {
                    timestable = progress;
                }
                Log.i("Seek bar value: ", Integer.toString(timestable));
                createView(timestable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}

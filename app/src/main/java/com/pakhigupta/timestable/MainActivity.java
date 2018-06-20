package com.pakhigupta.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public void generateTable(int timesTable) {

        ArrayList<String> table = new ArrayList<String>();
        for(int m=1; m<=10; m++) {
            table.add(timesTable + " * " + m + " = "+ (m * timesTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this , android.R.layout.simple_list_item_1, table);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMax(25);
        seekBar.setProgress(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min=1;
                int timesTable=0;
                if(i < min) {
                    timesTable = min;
                    seekBar.setProgress(min);
                }
                else {
                    timesTable = i;
                }
               // Toast.makeText(MainActivity.this, timesTable+"", Toast.LENGTH_SHORT).show();
                generateTable(timesTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(MainActivity.this ,"lalalalla",Toast.LENGTH_SHORT).show();
            }
        });


    }
}

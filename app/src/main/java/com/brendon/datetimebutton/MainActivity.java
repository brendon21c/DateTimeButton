package com.brendon.datetimebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "com.brendon.datetime";

    Button mAddTaskButton;
    ListView mTaskListView;
    Date mCreated;

    String mDateFormatTime;
    ArrayList<String> mTimeStamps;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAddTaskButton = (Button) findViewById(R.id.task_add_button);
        mTaskListView = (ListView) findViewById(R.id.task_list);

        mTimeStamps = new ArrayList<String>();

        final ArrayAdapter<String> dateTimeAdapter = new ArrayAdapter<String>(this,R.layout.list_item,
                R.id.item_entry,mTimeStamps);

        mTaskListView.setAdapter(dateTimeAdapter);


        mAddTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCreated = new Date();

                mDateFormatTime = "Button pressed at " + DateFormat.getTimeInstance().format(mCreated) + ". Thank you";

                Log.d(TAG, "Timestamp created");

                mTimeStamps.add(mDateFormatTime);
                dateTimeAdapter.notifyDataSetChanged();


            }
        });



    }


}

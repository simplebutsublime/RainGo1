package com.example.nick.raingo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Nick on 4/8/2016.
 */
public class SchedulePage extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.schedule_layout);

        Intent activityThatCalled = getIntent();

        //this gets the activity that called this activity, the data that we passed
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
    }
}

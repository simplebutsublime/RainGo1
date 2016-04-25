package com.example.nick.raingo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by Nick on 4/8/2016.
 */
public class SchedulePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_layout);
        Toolbar scheduleToolBar = (Toolbar) findViewById(R.id.schedule_toolbar);
        setSupportActionBar(scheduleToolBar);

        Intent activityThatCalled = getIntent();

        //this gets the activity that called this activity, the data that we passed
        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_schedule, menu);
        return true;
    }

    //Responds to actions on the action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_add:
                Intent getAddEventsPage = new Intent(this, AddEventsPage.class);
                startActivity(getAddEventsPage);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void jumpToMainPage(View view){
        Intent getHomePage = new Intent(this, MainActivity.class);
        startActivity(getHomePage);
    }
}

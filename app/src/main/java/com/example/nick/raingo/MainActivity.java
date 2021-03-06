package com.example.nick.raingo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.json.*;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String location = "Elizabethtown, PA";
    TextView locationName, temperature, weatherType;
    JsonParser weatherGet = new JsonParser();
    String[] locationInfo = new String[5];
    static final String STATE_LOCATION = "userLocation";
    Boolean locationMenuClick = false;
    Intent intent;

    public void weatherGet() {
        //locationInfo[0] is the name of the city, locationInfo[1] is the location key of the city
        locationInfo = weatherGet.locationFinder(location);
        weatherGet.currentConditions(locationInfo[1]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Toolbar mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
            setSupportActionBar(mainToolbar);
            intent = getIntent();
            if(intent != null){
                location = intent.getStringExtra(LocationsPage.EXTRA_MESSAGE);
                if(location == null){
                    location = "State College, PA";
                }
            }
            weatherGet();
            locationName = (TextView) findViewById(R.id.locationName);
            locationName.setText(locationInfo[0]);
            temperature = (TextView) findViewById(R.id.temperature);
            temperature.setText(weatherGet.tempValue + " " + weatherGet.tempUnit);
            weatherType = (TextView) findViewById(R.id.weatherType);
            weatherType.setText(weatherGet.weatherType);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //Responds to actions on the action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_location:
                Intent getLocationsPage = new Intent(this, LocationsPage.class);
                startActivity(getLocationsPage);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void jumpToClosetPage(View view) {
        Intent getClosetPage = new Intent(this, ClosetPage.class);

        final int result = 1;

        getClosetPage.putExtra("callingActivity","MainActivity");

        //this is if you don't want info back from next activity
        startActivity(getClosetPage);
        //this is if you want something back
        startActivityForResult(getClosetPage,result);
    }

    public void jumpToSchedulePage(View view) {
        Intent getSchedulePage = new Intent(this, SchedulePage.class);

        final int result = 1;

        getSchedulePage.putExtra("callingActivity","MainActivity");

        //this is if you don't want info back from next activity
        startActivity(getSchedulePage);
        //this is if you want something back
        startActivityForResult(getSchedulePage,result);

    }

}
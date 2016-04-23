package com.example.nick.raingo;

import android.content.Intent;
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
    String locationInfo = "";

    public void weatherGet() {
        locationInfo = weatherGet.locationFinder(location);
        //System.out.println(locationInfo[1]);
        //weatherGet.currentConditions(locationInfo[1]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Toolbar mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
            setSupportActionBar(mainToolbar);
            weatherGet();
            locationName = (TextView) findViewById(R.id.locationName);
            temperature = (TextView) findViewById(R.id.temperature);
            weatherType = (TextView) findViewById(R.id.weatherType);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
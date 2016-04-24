package com.example.nick.raingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by nitta_000 on 4/23/2016.
 */
public class LocationsPage extends AppCompatActivity{

    public final static String EXTRA_MESSAGE = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
    }

    public void sendLocation(View view){
        Intent mainPage = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_location);
        String location = editText.getText().toString();
        mainPage.putExtra(EXTRA_MESSAGE, location);
        startActivity(mainPage);
    }

}

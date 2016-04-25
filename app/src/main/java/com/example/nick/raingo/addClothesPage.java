package com.example.nick.raingo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/**
 * Created by nitta_000 on 4/24/2016.
 */
public class AddClothesPage extends AppCompatActivity{

    Spinner spinner;
    SpinnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_page);
        String[] clothingType = {"Hat", "Shirt", "Pants", "Shoes"};
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, clothingType);
        spinner.setAdapter(adapter);
    }

}

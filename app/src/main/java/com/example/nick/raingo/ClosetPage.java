package com.example.nick.raingo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.io.File;

/**
 * Created by Nick on 4/8/2016.
 */
public class ClosetPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.closet_layout);
        Toolbar closetToolbar = (Toolbar) findViewById(R.id.closet_toolbar);
        setSupportActionBar(closetToolbar);
        String[] clothes = {"Batman Tee", "Khaki Shorts", "Nike Sneakers"};
        ListAdapter clothesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clothes);
        ListView clothesListView = (ListView) findViewById(R.id.clothes_list);
        clothesListView.setAdapter(clothesAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_closet, menu);
        return true;
    }

    //Responds to actions on the action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_add:
                Intent getAddClothesPage = new Intent(this, AddClothesPage.class);
                startActivity(getAddClothesPage);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}




package com.example.nick.raingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

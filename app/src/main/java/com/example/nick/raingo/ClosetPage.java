package com.example.nick.raingo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;

/**
 * Created by Nick on 4/8/2016.
 */
public class ClosetPage extends AppCompatActivity {

    SQLiteDatabase contactsDB = null;

    Button createClosetButton, addItemButton, deleteItemButton, getContactsButton,
            deleteDBButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.closet_layout);

        createClosetButton = (Button) findViewById(R.id.createClosetButton);
        addItemButton = (Button) findViewById(R.id.addItemButton);
        deleteItemButton = (Button) findViewById(R.id.deleteItemButton);
        getContactsButton = (Button) findViewById(R.id.getContactsButton);
        deleteDBButton = (Button) findViewById(R.id.deleteDBButton);

    }

    public void createDatabase(View view) {

        try{

            // Opens a current database or creates it
            // Pass the database name, designate that only this app can use it
            // and a DatabaseErrorHandler in the case of database corruption
            contactsDB = this.openOrCreateDatabase("MyContacts", MODE_PRIVATE, null);

            // Execute an SQL statement that isn't select
            contactsDB.execSQL("CREATE TABLE IF NOT EXISTS contacts " +
                    "(id integer primary key, name VARCHAR, email VARCHAR);");

            // The database on the file system
            File database = getApplicationContext().getDatabasePath("MyContacts.db");

            // Check if the database exists
            if (database.exists()) {
                Toast.makeText(this, "Database Created", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Database Missing", Toast.LENGTH_SHORT).show();
            }


        }

        catch(Exception e){

            Log.e("CONTACTS ERROR", "Error Creating Database");

        }

        // Make buttons clickable since the database was created
        addItemButton.setClickable(true);
        deleteItemButton.setClickable(true);
        getContactsButton.setClickable(true);
        deleteDBButton.setClickable(true);

    }

    public void addItem(View view) {

        // Get the contact name and email entered
        String contactName = "Kevin Means";
        String contactEmail = "kvnmeans9@gmail.com";

        // Execute SQL statement to insert new data
        contactsDB.execSQL("INSERT INTO contacts (name, email) VALUES ('" +
                contactName + "', '" + contactEmail + "');");

    }

    public void getContacts(View view) {

        // A Cursor provides read and write access to database results
        Cursor cursor = contactsDB.rawQuery("SELECT * FROM contacts", null);

        // Get the index for the column name provided
        int idColumn = cursor.getColumnIndex("id");
        int nameColumn = cursor.getColumnIndex("name");
        int emailColumn = cursor.getColumnIndex("email");

        // Move to the first row of results
        cursor.moveToFirst();

        String contactList = "";

        // Verify that we have results
        if(cursor != null && (cursor.getCount() > 0)){

            do{
                // Get the results and store them in a String
                String id = cursor.getString(idColumn);
                String name = cursor.getString(nameColumn);
                String email = cursor.getString(emailColumn);

                contactList = contactList + id + " : " + name + " : " + email + "\n";

                // Keep getting results as long as they exist
            }while(cursor.moveToNext());

        } else {

            Toast.makeText(this, "No Results to Show", Toast.LENGTH_SHORT).show();

        }

    }

    public void deleteContact(View view) {

        // Get the id to delete
        String id = "";

        // Delete matching id in database
        contactsDB.execSQL("DELETE FROM contacts WHERE id = " + id + ";");

    }

    public void deleteDatabase(View view) {

        // Delete database
        this.deleteDatabase("MyContacts");

    }

    @Override
    protected void onDestroy() {

        contactsDB.close();

        super.onDestroy();
    }

}




package com.jemslab.android.phonenumbersgenerator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main); */
        setContentView(R.layout.phones_listings);
        randomGenerator();
    }

    private void randomGenerator() {
        String phoneNumber="jefflilcot";
        String country = "kenya";
        ArrayList<Phones> phonesArray = new ArrayList<>();
        int i= 0;

        while(i < 1000) phonesArray.add(new Phones(phoneNumber + i++, country));

        PhonesListAdapter adapter = new PhonesListAdapter(this,phonesArray);
        ListView myListView = (ListView) findViewById(R.id.phoneListingView);
        myListView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}


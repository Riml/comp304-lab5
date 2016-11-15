package com.comp304.group1.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] cuisinesArray= {"Chinese","Russian","Italian","Japanese"};
    ListView cuisinesView;
    ArrayAdapter cuisinesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cuisinesView = (ListView) findViewById(R.id.cuisineView);

        cuisinesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cuisinesArray);

        // Attach the array adapter to the spinner
        cuisinesView.setAdapter(cuisinesAdapter);

        cuisinesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent;
                String selectedSetting = (String) cuisinesView.getItemAtPosition(position);
                intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                intent.putExtra("cuisine", selectedSetting);
                startActivity(intent);
            }
        });
    }
}
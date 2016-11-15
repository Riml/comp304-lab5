package com.comp304.group1.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantsActivity extends AppCompatActivity {

    String chosenCuisine="";
    List<String> chosenCuisineArray= new ArrayList<String>();
    List<String> chosenlocationsArray= new ArrayList<String>();
    ListView restaurantListView;
    ArrayAdapter restaurantAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        chosenCuisine=getIntent().getStringExtra("cuisine");
        switch (chosenCuisine){
            case "Russian":
                chosenCuisineArray= Arrays.asList(getResources().getStringArray(R.array.RussianNames));
                chosenlocationsArray= Arrays.asList(getResources().getStringArray(R.array.RussianLocation));
                break;
            case "Chinese":
                chosenCuisineArray=Arrays.asList(getResources().getStringArray(R.array.ChineseNames));
                chosenlocationsArray=Arrays.asList(getResources().getStringArray(R.array.ChineseLocation));
                break;
            case "Italian":
                chosenCuisineArray=Arrays.asList(getResources().getStringArray(R.array.ItalianNames));
                chosenlocationsArray=Arrays.asList(getResources().getStringArray(R.array.ItalianLocation));
                break;
            case "Japanese":
                chosenCuisineArray=Arrays.asList(getResources().getStringArray(R.array.JapaneseNames));
                chosenlocationsArray=Arrays.asList(getResources().getStringArray(R.array.JapaneseLocation));
                break;


        }


        ((TextView)findViewById(R.id.txtSelectedCuisine)).setText("Chosen Cuisine: "+ chosenCuisine);

        restaurantListView = (ListView) findViewById(R.id.lvRestaurant);

        restaurantAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chosenCuisineArray);

        restaurantListView.setAdapter(restaurantAdapter);


        restaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent;
                String selectedSetting = (String) restaurantListView.getItemAtPosition(position);

                intent = new Intent(RestaurantsActivity.this, MapsActivity.class);
                String temp1 = (String)chosenlocationsArray.get(position);
                String[] coordinates = temp1.split(",");
                intent.putExtra("Lat", Double.parseDouble(coordinates[0]));
                intent.putExtra("Lng", Double.parseDouble(coordinates[1]));
                intent.putExtra("Rst", selectedSetting);
                startActivity(intent);
            }
        });

    }
}

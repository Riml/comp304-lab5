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

public class RestaurantsActivity extends AppCompatActivity {

    String chosenCuisine="";
    String[] restArrayChinese= {"Chinese1","Chinese2","Chinese3","Chinese4"};
    String[] restArrayRussian= {"Russian1","Russian2","Russian3","Russian4"};
    String[] restArrayItalian= {"Italian1","Italian2","Italian3","Italian4"};
    String[] restArrayJapanese= {"Japanese1","Japanese2","Japanese3","Japanese4"};

    String[] chosenCuisineArray;
    ListView restaurantListView;
    ArrayAdapter restaurantAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        chosenCuisine=getIntent().getStringExtra("cuisine");
        switch (chosenCuisine){
            case "Russian":
                chosenCuisineArray=restArrayRussian;
                break;
            case "Chinese":
                chosenCuisineArray=restArrayChinese;
                break;
            case "Italian":
                chosenCuisineArray=restArrayItalian;
                break;
            case "Japanese":
                chosenCuisineArray=restArrayJapanese;
                break;


        }
        Log.i("CUS",chosenCuisineArray[0].toString());

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
                intent.putExtra("re", selectedSetting);
                startActivity(intent);
            }
        });

    }
}

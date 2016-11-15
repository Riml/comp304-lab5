package com.comp304.group1.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


        }

        ((TextView)findViewById(R.id.txtSelectedCuisine)).setText("Chosen Cuisine: "+ chosenCuisine);

        restaurantListView = (ListView) findViewById(R.id.cuisineView);

        restaurantAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chosenCuisineArray);

        // Attach the array adapter to the spinner
        restaurantListView.setAdapter(restaurantAdapter);

    }
}

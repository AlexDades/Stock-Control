package com.example.android.stockcontrol;
import com.example.android.stockcontrol.StockIn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {
    String barcode, format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

    //Creating a location adapter
        ProductAdapter adapter = new ProductAdapter(this);

        //Assigning a listView to the location list layout
        ListView listView = (ListView) findViewById(R.id.product_list);

        //Setting an adapter onto the listView
        listView.setAdapter(adapter);

    }
}




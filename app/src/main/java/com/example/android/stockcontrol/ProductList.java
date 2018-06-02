package com.example.android.stockcontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ProductList extends AppCompatActivity {
    String barcode;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_view);
        listView = findViewById(R.id.product_list_view);
        List<Product> products = getProductList();
        ProductAdapter adapter = new ProductAdapter(this, products);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Intent transfer = new Intent(ProductList.this, ProductDetails.class);
//                transfer.putExtra("barcode", Product.getBarCode());
//                transfer.putExtra("name", Product.getName());
//                transfer.putExtra("quantity", Product.getQuantity());
//                startActivity(transfer);
            }
        });
    }

    private List<Product> getProductList() {
        List<Product> products = new ArrayList<>();
        try{
            XMLPullParserHandler parser = new XMLPullParserHandler();
            InputStream xml = getAssets().open("products.xml");
            products = parser.parse(xml);
        }catch (IOException e){
            e.printStackTrace();
        }
        return products;
    }
}




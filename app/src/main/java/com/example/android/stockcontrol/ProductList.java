package com.example.android.stockcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

public class ProductList extends AppCompatActivity {
    String barcode, format;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.list_view);*/

/*        final ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("4342233001353", "Zizin", "2L"));
        products.add(new Product("1342233001353", "Aqua", "1L"));
        products.add(new Product("2342223201353", "Borsec", "2L"));
        products.add(new Product("5642969001353", "Vitel", "1L"));
        products.add(new Product("1842209801353", "Joe", "1 buc"));
        products.add(new Product("9142231231353", "Chio", "1 buc"));
        products.add(new Product("9942233001353", "Star", "1 buc"));
        products.add(new Product("1242233001353", "Pringles", "1 buc"));
        products.add(new Product("1742233001353", "Nutline", "1 buc"));
        products.add(new Product("7142233001353", "Cocos", "1 buc"));
        products.add(new Product("9342233001353", "KitKat", "1 buc"));
        products.add(new Product("9442233001353", "Sneekers", "1 buc"));
        products.add(new Product("4342233001353", "Zizin", "1 buc"));
        products.add(new Product("1342233001353", "Aqua", "1 buc"));
        products.add(new Product("2342223201353", "Borsec", "1 buc"));
        products.add(new Product("5642969001353", "Vitel", "1 buc"));
        products.add(new Product("1842209801353", "Joe", "1 buc"));
        products.add(new Product("9142231231353", "Chio", "1 buc"));
        products.add(new Product("9942233001353", "Star", "1 buc"));
        products.add(new Product("1242233001353", "Pringles", "1 buc"));
        products.add(new Product("1742233001353", "Nutline", "1 buc"));
        products.add(new Product("7142233001353", "Cocos", "1 buc"));
        products.add(new Product("9342233001353", "KitKat", "1 buc"));
        products.add(new Product("9442233001353", "Sneekers", "1 buc"));*/

        listView = (ListView) findViewById(R.id.list);
        List<Product> products = null;

        try{
            XMLPullParserHandler parser = new XMLPullParserHandler();
            products = parser.parse(getAssets().open("products.xml"));
        }catch (IOException e){
            e.printStackTrace();
        }

        ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(ProductList.this, R.layout.list_item, products);
        listView.setAdapter(adapter);

/*    //Creating a location adapter
        ProductAdapter adapter = new ProductAdapter(this, products);*/

/*        //Assigning a listView to the location list layout
        ListView listView = (ListView) findViewById(R.id.item_view);

        //Setting an adapter onto the listView
        listView.setAdapter(adapter);*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent transfer = new Intent(ProductList.this, ProductDetails.class);
                transfer.putExtra("barcode", Product.getBarCode());
                transfer.putExtra("name", Product.getName());
                transfer.putExtra("quantity", Product.getQuantity());
                startActivity(transfer);
            }
        });

    }
}




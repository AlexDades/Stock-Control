package com.example.android.stockcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.com.google.zxing.integration.android.IntentIntegrator;
import com.com.google.zxing.integration.android.IntentResult;

public class StockWatch extends AppCompatActivity {
    Button scanStockwatch, registerQuantity;
    ImageView back, productImage;
    TextView productBarcode, productName, productQuantity;
    EditText quantityAvailable;
    String barcode;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_watch);

        scanStockwatch = findViewById(R.id.scan_stockwatch_button);
        scanStockwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.scan_stockwatch_button) {
                    IntentIntegrator scanIntegrator = new IntentIntegrator(StockWatch.this);
                    scanIntegrator.initiateScan();
                }
            }
        });
        back = findViewById(R.id.back_to_menu);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(StockWatch.this, Menu.class);
                startActivity(back);
            }
        });
        productBarcode = findViewById(R.id.product_barcode);
        productName = findViewById(R.id.product_name);
        productQuantity = findViewById(R.id.product_quantity);
        quantityAvailable = findViewById(R.id.quantity_stock_watch);
        registerQuantity = findViewById(R.id.register_quantity);
        productImage = findViewById(R.id.product_image);
        registerQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StockWatch.this, "Registered", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            barcode = scanningResult.getContents();
            if (barcode.equals("5942233001353")) {
                productName.setText(R.string.zizin);
                productQuantity.setText(R.string.quantity);
                productBarcode.setText(barcode);
                productImage.setImageResource(R.drawable.zizin);
            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

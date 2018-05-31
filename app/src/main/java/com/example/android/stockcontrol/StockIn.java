package com.example.android.stockcontrol;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.com.google.zxing.integration.android.IntentIntegrator;
import com.com.google.zxing.integration.android.IntentResult;
import com.data.ProductDBHelper;
import com.data.ProductsContract;
import com.data.SQLHelper;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class StockIn extends AppCompatActivity {

    private Button scanBtn, register;
    private EditText productName, productQuantity;
    ImageView back, forward;
    String barcode;
    SQLiteDatabase db;
    TextView productBarcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_in);
        scanBtn = findViewById(R.id.scan_button);
        productName = findViewById(R.id.product_name);
        productQuantity = findViewById(R.id.product_quantity);
        back = findViewById(R.id.back);
        register = findViewById(R.id.register_button);
        productBarcode = findViewById(R.id.product_barcode);
        forward = findViewById(R.id.forward);
        scanBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.scan_button) {
                    IntentIntegrator scanIntegrator = new IntentIntegrator(StockIn.this);
                    scanIntegrator.initiateScan();
                }
            }
        });

        //Back to Menu
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent back = new Intent(StockIn.this, Menu.class);
                startActivity(back);
            }
        });

        //Forward to Prod
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forward = new Intent(StockIn.this, ProductList.class);
                startActivity(forward);
            }
        });
        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StockIn.this, "Product Registered", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            barcode = scanningResult.getContents();
            if (barcode.equals("5942233001353")) {
                productBarcode.setText("5942233001353");
            }
            register.setActivated(true);
        } else {
            register.setActivated(false);
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}


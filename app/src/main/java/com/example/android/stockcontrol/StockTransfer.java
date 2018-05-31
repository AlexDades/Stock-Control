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

public class StockTransfer extends AppCompatActivity {
    Button scan, transfer;
    ImageView back;
    TextView productBarcode, productName, productQuantity;
    EditText toStore, quantityForTransfer;
    String barcode;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_transfer);

        scan = findViewById(R.id.scan_button);
        transfer = findViewById(R.id.stock_transfer_button);
        back = findViewById(R.id.back_to_menu);
        productBarcode = findViewById(R.id.product_barcode);
        productName = findViewById(R.id.product_name);
        productQuantity = findViewById(R.id.product_quantity);
        toStore = findViewById(R.id.to_store_text_view);
        quantityForTransfer = findViewById(R.id.product_quantity_for_transfer);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.scan_button) {
                    IntentIntegrator scanIntegrator = new IntentIntegrator(StockTransfer.this);
                    scanIntegrator.initiateScan();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(StockTransfer.this, Menu.class);
                startActivity(back);
            }
        });
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StockTransfer.this, "Stock Transfered", Toast.LENGTH_SHORT).show();
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
            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

package com.example.android.stockcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.stockcontrol.FloatingMenu;

import com.com.google.zxing.integration.android.IntentIntegrator;
import com.com.google.zxing.integration.android.IntentResult;

public class Discounts extends AppCompatActivity {

    Button scan, applyDiscount;
    String barCode;
    TextView productQuantity, productName, productPrice;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discounts);

        scan = findViewById(R.id.scan_item_for_discount);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.scan_item_for_discount) {
                    IntentIntegrator scanIntegrator = new IntentIntegrator(Discounts.this);
                    scanIntegrator.initiateScan();
                }
            }
        });

        productName = findViewById(R.id.product_name);
        productQuantity = findViewById(R.id.product_quantity);
        productPrice = findViewById(R.id.product_price);

        applyDiscount = findViewById(R.id.apply_discount_button);
        applyDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Discounts.this, applyDiscount);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.menu_tab, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.five_percent:
                                productPrice.setText(R.string.zizin_five_percent_discount);
                                return true;
                            case R.id.ten_percent:
                                productPrice.setText(R.string.zizin_ten_percent_discount);
                                return true;
                            case R.id.twenty_percent:
                                productPrice.setText(R.string.zizin_twenty_percent_discount);
                                return true;
                        }
                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener method

        backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Discounts.this, Menu.class);
                startActivity(back);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            barCode = scanningResult.getContents();

            if (barCode.equals("5942233001353")) {
                productName.setText(R.string.zizin);
                productQuantity.setText(R.string.quantity);
                productPrice.setText(R.string.zizin_price_value);
            } else if (barCode.equals("9991017138798")) {
                productName.setText(R.string.carrefour);
                productQuantity.setText(R.string.number);
                productPrice.setText(R.string.card_price_value);
            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


}

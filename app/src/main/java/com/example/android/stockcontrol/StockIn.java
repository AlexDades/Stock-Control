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
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class StockIn extends AppCompatActivity implements OnClickListener {

    private Button scanBtn, register;
    private EditText productName, productQuantity;
    ImageView back, forward;
    String barcode;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_in);
        db = getDatabase();
        scanBtn = findViewById(R.id.scan_button);
        productName = findViewById(R.id.product_name);
        productQuantity = findViewById(R.id.product_quantity);
        back =  findViewById(R.id.back);
        register = createRegisterButton();
        forward = findViewById(R.id.forward);
        scanBtn.setOnClickListener(this);

        //Back to Menu
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent back = new Intent(StockIn.this, Menu.class);
                startActivity(back);
            }
        });

        //Forward to Prod
        forward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent forward = new Intent(StockIn.this, ProductList.class);
                startActivity(forward);
            }
        });



    }
    public void onClick(View v){
        if(v.getId()==R.id.scan_button){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            barcode = scanningResult.getContents();
            register.setActivated(true);
        }
        else{
            register.setActivated(false);
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private SQLiteDatabase getDatabase(){
        SQLHelper helper = new SQLHelper(getApplicationContext());
        return helper.getWritableDatabase();

    }

    private Button createRegisterButton(){
        Button b = findViewById(R.id.register_button);
        b.setActivated(false);
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product(barcode, productName.getText().toString(), productQuantity.getText().toString());
                String[] columns = db.query(ProductsContract.Products.TABLE_NAME, null, null, null, null, null, null).getColumnNames();
                for(String name : columns){
                    Log.d("Column name", name);
                }
                db.insert(ProductsContract.Products.TABLE_NAME, null, ProductDBHelper.getContentValuesForProduct(product));
                Toast.makeText(StockIn.this, "Product successfully registered", Toast.LENGTH_SHORT).show();
            }
        });
        return b;
    }


}


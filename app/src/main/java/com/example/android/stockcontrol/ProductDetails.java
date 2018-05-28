package com.example.android.stockcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.com.google.zxing.integration.android.IntentIntegrator;
import com.com.google.zxing.integration.android.IntentResult;
import com.data.ProductsContract;
import com.data.SQLHelper;
import com.example.android.stockcontrol.R;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import static com.data.ProductsContract.Products.*;

import com.com.google.zxing.integration.android.IntentIntegrator;
import com.com.google.zxing.integration.android.IntentResult;

public class ProductDetails extends AppCompatActivity {
    TextView productName, productQuantity;
    ImageView productImage, back;
    String barCode;
    Button scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        productName = findViewById(R.id.product_name);
        productQuantity = findViewById(R.id.product_quantity);
        productImage = findViewById(R.id.product_image);
        scan = findViewById(R.id.scan_details_button);
        scan.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.scan_details_button){
                    IntentIntegrator scanIntegrator = new IntentIntegrator(ProductDetails.this);
                    scanIntegrator.initiateScan();
                }
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ProductDetails.this, Menu.class);
                startActivity(back);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            barCode = scanningResult.getContents();

            if(barCode.equals ("5942233001353")){
                productName.setText(R.string.zizin);
                productQuantity.setText(R.string.quantity);
                productImage.setImageResource(R.drawable.zizin);
            }
            else if(barCode.equals ("9991017138798")){
                productName.setText(R.string.carrefour);
                productQuantity.setText(R.string.number);
                productImage.setImageResource(R.drawable.carrefour);
            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

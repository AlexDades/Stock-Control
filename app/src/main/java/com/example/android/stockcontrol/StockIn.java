package com.example.android.stockcontrol;
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

import java.io.File;
import java.io.FileOutputStream;

public class StockIn extends AppCompatActivity implements OnClickListener {

    private Button scanBtn, register;
    private TextView formatTxt, contentTxt;
    ImageView back, forward;
    String scanContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_in);

        scanBtn = (Button)findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        back =  findViewById(R.id.back);
        register = findViewById(R.id.register_button);
        forward = findViewById(R.id.forward);
        scanBtn.setOnClickListener(this);

        SQLHelper mDBHelper = new SQLHelper(this);
        SQLiteDatabase db = mDBHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, "Zizin");
        values.put(COLUMN_BARCODE, scanContent);
        values.put(_ID, 1);
        values.put(COLUMN_QUANTITY, "2L");
        db.insert(ProductsContract.Products.TABLE_NAME, null, values);



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
            scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();


            if(scanContent.equals ("5942233001353") && scanFormat.equals("EAN_13"))
            formatTxt.setText("Zizin - Apa plata");
            contentTxt.setText("Cantitate: 1L");
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}


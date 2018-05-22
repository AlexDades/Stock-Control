package com.example.android.stockcontrol;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.com.google.zxing.integration.android.IntentIntegrator;
import com.com.google.zxing.integration.android.IntentResult;
import com.example.android.stockcontrol.R;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class StockIn extends AppCompatActivity implements OnClickListener {

    private Button scanBtn;
    private TextView formatTxt, contentTxt;
    ImageView back, forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_in);

        scanBtn = (Button)findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        back =  findViewById(R.id.back);
        forward = findViewById(R.id.forward);
        scanBtn.setOnClickListener(this);

        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent back = new Intent(StockIn.this, Menu.class);
                startActivity(back);
            }
        });

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
            String scanContent = scanningResult.getContents();
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


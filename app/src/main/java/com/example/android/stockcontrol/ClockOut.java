package com.example.android.stockcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.com.google.zxing.integration.android.IntentIntegrator;
import com.com.google.zxing.integration.android.IntentResult;

public class ClockOut extends AppCompatActivity {
    String barcode;
    ImageView backToMenu;
    TextView employeeName, employeeRole, employeeCode;
    Button scanBtn, clockOut;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_out);

        employeeName = findViewById(R.id.employee_name_text_view);
        employeeRole = findViewById(R.id.employee_role_text_view);
        employeeCode = findViewById(R.id.employee_code_text_view);
        clockOut = findViewById(R.id.clock_out_button);

        backToMenu = findViewById(R.id.back_to_menu);
        backToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToMenu = new Intent(ClockOut.this, Menu.class);
                startActivity(backToMenu);

            }
        });

        clockOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ClockOut.this, "Employee clocked out", Toast.LENGTH_SHORT).show();
            }
        });


        scanBtn = findViewById(R.id.scan_button);
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.scan_button) {
                    IntentIntegrator scanIntegrator = new IntentIntegrator(ClockOut.this);
                    scanIntegrator.initiateScan();
                }
            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            barcode = scanningResult.getContents();

            if (barcode.equals("9991017138798")) {
                employeeName.setText("John Doe");
                employeeRole.setText("Manager");
                employeeCode.setText(barcode);
            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
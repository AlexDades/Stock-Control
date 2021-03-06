package com.example.android.stockcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.com.google.zxing.integration.android.IntentIntegrator;
import com.com.google.zxing.integration.android.IntentResult;

public class ClockIn extends AppCompatActivity {

    ImageView back, forwardToDetails;
    Button scanBtn, clockIn;
    String barcode;
    TextView employeeName, employeeRole, employeeCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_in);

        employeeName = findViewById(R.id.employee_name_text_view);
        employeeRole = findViewById(R.id.employee_role_text_view);
        employeeCode = findViewById(R.id.employee_code_text_view);

        back = findViewById(R.id.back_to_menu);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(ClockIn.this, Menu.class);
                startActivity(back);
            }
        });

        scanBtn = findViewById(R.id.scan_button);
        scanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.scan_button) {
                    IntentIntegrator scanIntegrator = new IntentIntegrator(ClockIn.this);
                    scanIntegrator.initiateScan();
                }
            }
        });

        forwardToDetails = findViewById(R.id.forward_to_employee_details);
        forwardToDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forwardToDtails = new Intent (ClockIn.this, EmployeeList.class);
                startActivity(forwardToDtails);
            }
        });


        clockIn = findViewById(R.id.clock_in_button);
        clockIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ClockIn.this, "Clocked in", Toast.LENGTH_SHORT).show();
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

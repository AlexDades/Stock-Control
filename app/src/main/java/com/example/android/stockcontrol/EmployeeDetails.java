package com.example.android.stockcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.com.google.zxing.integration.android.IntentIntegrator;

public class EmployeeDetails extends AppCompatActivity {

    TextView employeeName, employeeRole, employeeBarcode;
    ImageView  back;
    Button scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_details);

        employeeName = findViewById(R.id.employee_details_name_text_view);
        employeeRole = findViewById(R.id.employee_details_role_text_view);
        employeeBarcode = findViewById(R.id.employee_details_code_text_view);

        String name = getIntent().getStringExtra("name");
        String barcode = getIntent().getStringExtra("role");
        String role = getIntent().getStringExtra("barcode");

        employeeName.setText(name);
        employeeRole.setText(role);
        employeeBarcode.setText(barcode);


        scan = findViewById(R.id.scan_employee_details_button);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.scan_employee_details_button){
                    IntentIntegrator scanIntegrator = new IntentIntegrator(EmployeeDetails.this);
                    scanIntegrator.initiateScan();
                }
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(EmployeeDetails.this, Menu.class);
                startActivity(back);
            }
        });
    }
}

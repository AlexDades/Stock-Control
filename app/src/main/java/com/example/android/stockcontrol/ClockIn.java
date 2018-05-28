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

import java.time.Clock;

public class ClockIn extends AppCompatActivity {

    ImageView back;
    Button scanEmployeeId;
    String employeeID;
    TextView employeeName, employeeRole, employeeCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_in);

        employeeName = findViewById(R.id.employee_name_text_view);
        employeeRole = findViewById(R.id.employee_role_text_view);
        employeeCode = findViewById(R.id.employee_code_text_view);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent (ClockIn.this, Menu.class);
                startActivity(back);
            }
        });

        scanEmployeeId = findViewById(R.id.scan_employee_id);
        scanEmployeeId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.scan_employee_id) {
                    IntentIntegrator scanIntegrator = new IntentIntegrator(ClockIn.this);
                    scanIntegrator.initiateScan();
                }
            }
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            employeeID = scanningResult.getContents();

            if(employeeID.equals("9991017138798")) {
                employeeName.setText("John Doe");
                employeeRole.setText("Manager");
                employeeCode.setText(employeeID);

                Intent sendId = new Intent(ClockIn.this, Employee.class);
                sendId.putExtra("employee_id", employeeID);
                sendId.putExtra("employee_name", employeeName.toString());
                sendId.putExtra("employee_role", employeeRole.toString());
                startActivity(sendId);

            }
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}

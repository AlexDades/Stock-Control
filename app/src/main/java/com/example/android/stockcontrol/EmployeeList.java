package com.example.android.stockcontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.android.stockcontrol.ClockIn;

import java.util.ArrayList;

public class EmployeeList extends AppCompatActivity {

    String employeeId = getIntent().getStringExtra("employee_id");
    String employeeName = getIntent().getStringExtra("employee_name");
    String employeeRole = getIntent().getStringExtra("employee_role");
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_list);

        final ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(employeeName, employeeRole, employeeId));

        EmployeeAdapter adapter = new EmployeeAdapter(this, employees);

        //Assigning a listView to the location list layout
        ListView listView = (ListView) findViewById(R.id.product_list);

        //Setting an adapter onto the listView
        listView.setAdapter(adapter);
    }
}

package com.example.android.stockcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EmployeeList extends AppCompatActivity {
        String barcode, format;
        ListView listView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_view);

            final ArrayList<Employee> employees = new ArrayList<>();
            employees.add(new Employee("John Doe", "Manager", "9991017138798"));
            employees.add(new Employee("John Doe", "Manager", "9991017138798"));
            employees.add(new Employee("John Doe", "Manager", "9991017138798"));
            employees.add(new Employee("John Doe", "Manager", "9991017138798"));

            listView = findViewById(R.id.list);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Intent transferEmployee = new Intent(com.example.android.stockcontrol.EmployeeList.this, EmployeeDetails.class);
                    transferEmployee.putExtra("name", Employee.getName());
                    transferEmployee.putExtra("role", Employee.getRole());
                    transferEmployee.putExtra("barcode", Employee.getBarCode());
                    startActivity(transferEmployee);
                }
            });

            //Creating a location adapter
            EmployeeAdapter adapter = new EmployeeAdapter(this, employees);

            //Assigning a listView to the location list layout
            ListView listView = (ListView) findViewById(R.id.list);

            //Setting an adapter onto the listView
            listView.setAdapter(adapter);

        }
    }

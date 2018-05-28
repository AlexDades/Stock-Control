package com.example.android.stockcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button stockIn, productList, discounts, productDetails, clockIn, employeeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        stockIn = findViewById(R.id.stock_in);
        productList = findViewById(R.id.product_list);
        discounts = findViewById(R.id.discounts);
        productDetails = findViewById(R.id.product_details);
        clockIn = findViewById(R.id.clock_in);
        employeeList = findViewById(R.id.employee_list);

        stockIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stockIn = new Intent(Menu.this, StockIn.class);
                startActivity(stockIn);
            }
        });

        productList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productList = new Intent(Menu.this, ProductList.class);
                startActivity(productList);
            }
        });

        productDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent productDetails = new Intent(Menu.this, ProductDetails.class);
                startActivity(productDetails);
            }
        });

        discounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent (Menu.this, Discounts.class);
                startActivity(menu);
            }
        });

        clockIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent clockIn = new Intent(Menu.this, ClockIn.class);
                startActivity(clockIn);
            }
        });
        employeeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent employeeList = new Intent(Menu.this, EmployeeList.class);
                startActivity(employeeList);
            }
        });
    }
}

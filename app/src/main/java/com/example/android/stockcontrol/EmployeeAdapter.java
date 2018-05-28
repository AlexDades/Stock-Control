package com.example.android.stockcontrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    public EmployeeAdapter(Context context, ArrayList<Employee> employees) {
        super(context, 0, employees);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Storing current location position
        Employee currentEmployee = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentEmployee.getName());

        TextView quantityTextView = listItemView.findViewById(R.id.quantity_text_view);
        quantityTextView.setText(currentEmployee.getRole());

        TextView barcodeTextView = listItemView.findViewById(R.id.barcode_text_view);
        barcodeTextView.setText(currentEmployee.getCode());

        return listItemView;
    }

    {
    }
}
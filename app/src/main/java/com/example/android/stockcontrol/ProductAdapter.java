package com.example.android.stockcontrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.data.ProductDBHelper;
import com.data.SQLHelper;
import com.example.android.stockcontrol.cache.ProductCache;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {

    public ProductAdapter(Context context) {
        super(context, 0, ProductDBHelper.getAllProducts(new SQLHelper(context).getWritableDatabase()));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Storing current location position
        Product currentProduct = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentProduct.getName());

        TextView quantityTextView = listItemView.findViewById(R.id.quantity_text_view);
        quantityTextView.setText(currentProduct.getQuantity());

        TextView barcodeTextView = listItemView.findViewById(R.id.barcode_text_view);
        barcodeTextView.setText(currentProduct.getBarCode());

        return listItemView;
    }
}
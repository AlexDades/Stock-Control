package com.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.stockcontrol.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDBHelper {

    public static ContentValues getContentValuesForProduct(Product product){
        ContentValues values = new ContentValues();
        values.put(ProductsContract.Products._ID, 1);
        values.put(ProductsContract.Products.COLUMN_BARCODE, product.getBarCode());
        values.put(ProductsContract.Products.COLUMN_PRODUCT_NAME, product.getName());
        values.put(ProductsContract.Products.COLUMN_QUANTITY, product.getQuantity());
        return values;
    }

/*    public static List<Product> getAllProducts(SQLiteDatabase db){
        Cursor cursor = db.query(ProductsContract.Products.TABLE_NAME, null, null, null, null, null, null);
        List<Product> products = new ArrayList<>();
        while(cursor.moveToNext()){
            products.add(new Product(cursor.getString(1), cursor.getString(2), cursor.getString(3)));
        }
        return products;
    }*/
}

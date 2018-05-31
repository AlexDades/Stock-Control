package com.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.data.ProductsContract.Products.*;


public class SQLHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "products.db";
    private static final int DATABASE_VERSION = 1;
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*db.delete(TABLE_NAME, null, null);*/
        String SQL_CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_BARCODE + " TEXT NOT NULL,"
                + COLUMN_PRODUCT_NAME + " TEXT NOT NULL,"
                + COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 1)";
        db.execSQL(SQL_CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLHelper(Context context){
        super(context, DATABASE_NAME, null,  DATABASE_VERSION);
    }
}

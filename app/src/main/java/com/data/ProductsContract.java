package com.data;

import android.provider.BaseColumns;

public final class ProductsContract {

    public static abstract class Products implements BaseColumns{

        public static final String TABLE_NAME = "products";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PRODUCT_NAME = "Product Name";
        public final static String COLUMN_QUANTITY = "Quantity";
        public final static String COLUMN_BARCODE = "Barcode";
    }
}

package com.example.android.stockcontrol;

public class Product {

    private static String barCode;
    private static String name;
    private static String quantity;

/*    public Product (String pBarcode, String pName, String pQuantity){
        this.barCode = pBarcode;
        this.name = pName;
        this.quantity = pQuantity;
    }*/

    public static String getBarCode(){
        return barCode;
    }

    public static String getName(){
        return name;
    }

    public static String getQuantity(){
        return quantity;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setBarcode(String barcode){
        this.barCode = barcode;
    }

    public void setQuantity(String quantity){
        this.quantity = quantity;
    }
}


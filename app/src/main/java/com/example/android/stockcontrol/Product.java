package com.example.android.stockcontrol;

public class Product {

    String barCode;
    String name;
    String quantity;

    public Product (String pBarcode, String pNAme, String pQuantity){
        this.barCode = pBarcode;
        this.name = pNAme;
        this.quantity = pQuantity;
    }

    public String getBarCode(){
        return barCode;
    }

    public String getName(){
        return name;
    }

    public String getQuantity(){
        return quantity;
    }
}

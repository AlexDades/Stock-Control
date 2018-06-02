package com.example.android.stockcontrol;

public class Product {

    private String barCode;
    private String name;
    private String quantity;

    public Product(){}

    public Product (String pBarcode, String pName, String pQuantity){
        this.barCode = pBarcode;
        this.name = pName;
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


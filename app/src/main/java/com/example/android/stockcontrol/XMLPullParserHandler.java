package com.example.android.stockcontrol;


import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;


public class XMLPullParserHandler {

    List <Product> products = new ArrayList<>();;
    private Product product;
    private String text;

    public XMLPullParserHandler(){
        products = new ArrayList<Product>();
    }

    public List<Product> getProducts(){
        return products;
    }

    public List <Product> parse(InputStream is){
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;

        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            parser = factory.newPullParser();
            parser.setInput(is, null);

            int eventType = parser.getEventType();
            Product product = new Product();
            String tagName = "";
            while (eventType != XmlPullParser.END_DOCUMENT){
                switch(eventType){
                    case XmlPullParser.START_TAG:
                        tagName = parser.getName();
                        if(tagName.equals("product")){
                            product = new Product();
                        }
                    break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        if(tagName != null) {
                            if (tagName.equalsIgnoreCase("name")) {
                                product.setName(text);
                            } else if (tagName.equalsIgnoreCase("barcode")) {
                                product.setBarcode(text);
                            } else if (tagName.equalsIgnoreCase("quantity")) {
                                product.setQuantity(text);
                                products.add(product);
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        tagName = "";
                        break;
                    default:
                            break;
                }
                eventType = parser.next();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}

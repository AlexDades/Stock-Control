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

    List <Product> products;
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
            while (eventType != XmlPullParser.END_DOCUMENT){
                String tagName = parser.getName();
                switch(eventType){
                    case XmlPullParser.START_TAG:

                    if (tagName.equalsIgnoreCase("product")){
                        products = new List<Product>() {
                            @Override
                            public int size() {
                                return 0;
                            }

                            @Override
                            public boolean isEmpty() {
                                return false;
                            }

                            @Override
                            public boolean contains(Object o) {
                                return false;
                            }

                            @NonNull
                            @Override
                            public Iterator<Product> iterator() {
                                return null;
                            }

                            @NonNull
                            @Override
                            public Object[] toArray() {
                                return new Object[0];
                            }

                            @NonNull
                            @Override
                            public <T> T[] toArray(@NonNull T[] a) {
                                return null;
                            }

                            @Override
                            public boolean add(Product product) {
                                return false;
                            }

                            @Override
                            public boolean remove(Object o) {
                                return false;
                            }

                            @Override
                            public boolean containsAll(@NonNull Collection<?> c) {
                                return false;
                            }

                            @Override
                            public boolean addAll(@NonNull Collection<? extends Product> c) {
                                return false;
                            }

                            @Override
                            public boolean addAll(int index, @NonNull Collection<? extends Product> c) {
                                return false;
                            }

                            @Override
                            public boolean removeAll(@NonNull Collection<?> c) {
                                return false;
                            }

                            @Override
                            public boolean retainAll(@NonNull Collection<?> c) {
                                return false;
                            }

                            @Override
                            public void clear() {

                            }

                            @Override
                            public Product get(int index) {
                                return null;
                            }

                            @Override
                            public Product set(int index, Product element) {
                                return null;
                            }

                            @Override
                            public void add(int index, Product element) {

                            }

                            @Override
                            public Product remove(int index) {
                                return null;
                            }

                            @Override
                            public int indexOf(Object o) {
                                return 0;
                            }

                            @Override
                            public int lastIndexOf(Object o) {
                                return 0;
                            }

                            @NonNull
                            @Override
                            public ListIterator<Product> listIterator() {
                                return null;
                            }

                            @NonNull
                            @Override
                            public ListIterator<Product> listIterator(int index) {
                                return null;
                            }

                            @NonNull
                            @Override
                            public List<Product> subList(int fromIndex, int toIndex) {
                                return null;
                            }
                        };
                    }
                    break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(tagName.equalsIgnoreCase("product")){
                            products.add(product);
                        }else if (tagName.equalsIgnoreCase("name")){
                            product.setName(text);
                        }else if (tagName.equalsIgnoreCase("barcode")){
                            product.setBarcode(text);
                        }else if (tagName.equalsIgnoreCase("quantity")){
                            product.setQuantity(text);
                        }
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

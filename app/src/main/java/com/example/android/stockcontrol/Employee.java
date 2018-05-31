package com.example.android.stockcontrol;

public class Employee {
    static String name, role, code;

    public Employee(String eName, String eRole, String eCode){
        this.name = eName;
        this.role = eRole;
        this.code = eCode;
    }

    public static String getName(){
        return name;
    }

    public static String getRole(){
        return role;
    }

    public static String getBarCode(){
        return code;
    }
}

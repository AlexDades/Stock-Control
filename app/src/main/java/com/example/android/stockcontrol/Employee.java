package com.example.android.stockcontrol;

public class Employee {
    String name, role, code;

    public Employee(String eName, String eRole, String eCode){
        this.name = eName;
        this.role = eRole;
        this.code = eCode;
    }

    public String getName(){
        return name;
    }

    public String getRole(){
        return role;
    }

    public String getCode(){
        return code;
    }
}

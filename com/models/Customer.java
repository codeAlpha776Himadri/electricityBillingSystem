package com.models ;

import java.util.List ; 

public class Customer extends User {
    private String name;
    private List<Bill> previousBills;
    private Bill currentBill;

    public Customer(String username, String password, String name) {
        super(username, password);
        this.name = name;
        this.previousBills = null;
        this.currentBill = null;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name= name; 
    }

    public List<Bill> getPreviousBills() {
        return previousBills;
    }

    public void addPreviousBill(Bill previousBill) {
        this.previousBills.add(previousBill) ;
    }

    public Bill getCurrentBill() {
        return this.currentBill;
    }

    public boolean setCurrentBill(Bill currentBill) {
        this.currentBill = currentBill;
        return true ; 
    }
}
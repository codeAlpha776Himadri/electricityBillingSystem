package com.models; 


public class Bill {
    
    private static Integer billCount = 1 ; 
    
    private String id ; 
    private Customer customer ; 
    private double unitRate ; 
    private double units ;
    private double amt ; 
    
    public Bill(Customer customer, double unitRate, double units) {
        this.id = billCount.toString()  ; 
        this.customer = customer ;
        this.unitRate= unitRate ; 
        this.units = units ;
        this.amt = (unitRate * units) ; 
        billCount += 1; 
    }    
    
    
    public String getId() {
        return this.id ; 
    }
    
    
    public Customer getCustomer() {
        return this.customer ; 
    }
    
    
    public String toString() {
        return "id = "+ this.id + ", customer = "+ this.customer + ", unit_rate = "+ this.unitRate + 
                ", units = "+ this.units + ", amt = " + this.amt  ;
    }
    
    
}
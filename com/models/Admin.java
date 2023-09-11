
package com.models ;

public class Admin extends User {
    
    private double unitRate = 10.10 ; 
    
    public Admin(String username, String password) {
        super(username, password);
    }

    // Calculate the bill for a customer
    public double calculateBill(Customer customer, double unitsConsumed) {
        // You can implement your own billing logic here
        // For simplicity, we'll assume a fixed rate per unit
        double ratePerUnit = this.unitRate ; // Change this rate as needed
        double billAmount = unitsConsumed * ratePerUnit;
        customer.addPreviousBill(customer.getCurrentBill());
        customer.setCurrentBill(customer.getCurrentBill());
        return billAmount;
    }
}
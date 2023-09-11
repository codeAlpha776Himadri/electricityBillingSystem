package com ; 

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random ;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();
        Admin admin = new Admin("admin", "adminpass");

        while (true) {
            System.out.println(" **** Welcome to the Electricity Billing Application! **** ");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Customer");
            System.out.println("3. Sign Up as Customer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Admin login
                    System.out.print("Enter Admin username: ");
                    String adminUsername = scanner.nextLine();
                    System.out.print("Enter Admin password: ");
                    String adminPassword = scanner.nextLine();

                    if (adminUsername.equals(admin.getUsername()) && adminPassword.equals(admin.getPassword())) {
                        adminMenu(admin, customers, scanner);
                    } else {
                        System.out.println("Invalid credentials for Admin.");
                    }
                    break;

                case 2:
                    // Customer login
                    System.out.print("Enter Customer username: ");
                    String customerUsername = scanner.nextLine();
                    System.out.print("Enter Customer password: ");
                    String customerPassword = scanner.nextLine();

                    Customer customer = findCustomer(customerUsername, customerPassword, customers);
                    if (customer != null) {
                        customerMenu(customer, scanner);
                    } else {
                        System.out.println("Invalid credentials for Customer.");
                    }
                    break;

                case 3:
                    // Customer sign up
                    System.out.print("Enter Customer username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter Customer password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter Customer name: ");
                    String newName = scanner.nextLine();

                    Customer newCustomer = new Customer(newUsername, newPassword, newName);
                    customers.add(newCustomer);
                    System.out.println("Customer registration successful!");
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void adminMenu(Admin admin, ArrayList<Customer> customers, Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View all Customers");
            System.out.println("2. Calculate Bill for a Customer");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            int adminChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (adminChoice) {
                case 1:
                    viewAllCustomers(customers);
                    break;

                case 2:
                    System.out.print("Enter Customer username: ");
                    String customerUsername = scanner.nextLine();
                    Customer customer = findCustomerByUsername(customerUsername, customers);

                    if (customer != null) {
                        System.out.print("Enter units consumed: ");
                        double unitsConsumed = scanner.nextDouble();
                        double billAmount = admin.calculateBill(customer, unitsConsumed);
                        System.out.println("Bill calculated successfully.");
                        System.out.println("Previous Bill: $" + customer.getPreviousBill());
                        System.out.println("Current Bill: $" + customer.getCurrentBill());
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    System.out.println("Admin logout.");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void customerMenu(Customer customer, Scanner scanner) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Personal Details");
            System.out.println("2. View Previous Bills");
            System.out.println("3. Generate Current Bill");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int customerChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (customerChoice) {
                case 1:
                    viewCustomerDetails(customer);
                    break;

                case 2:
                    viewPreviousBills(customer);
                    break;

                case 3:
                    System.out.print("Enter units consumed: ");
                    double unitsConsumed = scanner.nextDouble();
                    double billAmount = customer.getCurrentBill();
                    System.out.println("Current Bill: $" + billAmount);
                    break;

                case 4:
                    System.out.println("Customer logout.");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static Customer findCustomer(String username, String password, ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return customer;
            }
        }
        return null;
    }

    private static Customer findCustomerByUsername(String username, ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    private static void viewAllCustomers(ArrayList<Customer> customers) {
        System.out.println("\nAll Customers:");
        for (Customer customer : customers) {
            System.out.println("Username: " + customer.getUsername() + ", Name: " + customer.getName());
        }
    }

    private static void viewCustomerDetails(Customer customer) {
        System.out.println("\nCustomer Details:");
        System.out.println("Name: " + customer.getName());
        System.out.println("Username: " + customer.getUsername());
    }

    private static void viewPreviousBills(Customer customer) {
        System.out.println("\nPrevious Bills for " + customer.getName() + ":");
        System.out.println("Previous Bill: $" + customer.getPreviousBill());
        System.out.println("Current Bill: $" + customer.getCurrentBill());
    }
    
}

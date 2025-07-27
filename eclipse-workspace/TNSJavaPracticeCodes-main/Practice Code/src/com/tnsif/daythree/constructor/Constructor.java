package com.tnsif.daythree.constructor;

import java.util.Scanner;

public class Constructor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer id:");
        int id = sc.nextInt();

        System.out.println("Enter Customer Name:");
        String name = sc.next();

        System.out.println("Enter Customer City:");
        String city = sc.next();

        System.out.println(" ");

        Customer c1 = new Customer(); // default constructor invoked

        c1.setCustomerId(id);
        c1.setCustomerName(name);
        c1.setCustomercity(city);

        System.out.println("Customer using setters:");
        System.out.println(c1);

        Customer c2 = new Customer(name, id, city); // parameterized constructor invoked
        System.out.println("Customer using parameterized constructor:");
        System.out.println(c2);

        sc.close();
    }
}

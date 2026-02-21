package com.epam;

import java.util.ArrayList;
import java.util.List;

class Main {
    static void main() {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1L, "test1", 1000.00));
        customers.add(new Customer(1L, "test1", 1000.00));
        customers.add(new Customer(1L, "test1", 1000.00));
        customers.add(new Customer(2L, "test2", 2000.00));
        customers.add(new Customer(2L, "test2", 2000.00));
        customers.add(new Customer(3L, "test3", 3000.00));
        customers.add(new Customer(4L, "test4", 4000.00));

        // Unique Customers
        List<Customer> uniqueCustomers = customers.stream()
                .distinct()
                .toList();

        System.out.println("Unique Customers:");

        uniqueCustomers.forEach(c ->
                System.out.println(c.getId() + " " + c.getName() + " " + c.getSalary()));

        // Sum of all salaries
        double totalSalary = customers.stream()
                .mapToDouble(Customer::getSalary)
                .sum();

        System.out.println("Total Salary (All): " + totalSalary);

        // Sum of unique salaries
        double totalUniqueSalary = customers.stream()
                .distinct()
                .mapToDouble(Customer::getSalary)
                .sum();

        System.out.println("Total Salary (Unique): " + totalUniqueSalary);
    }
}
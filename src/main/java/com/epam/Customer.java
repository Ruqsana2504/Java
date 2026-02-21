package com.epam;

import java.util.Objects;

class Customer {

    private final Long id;
    private final String name;
    private final Double salary;

    public Customer(Long id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    // equals() and hashCode() for distinct() to work properly
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(salary, customer.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    // Optional: toString() for clean printing
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
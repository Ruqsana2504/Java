package com.comparatorcomparable;

import java.util.*;

public class ComparatorVsComparable {

    public static void main(String[] args) {

        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(21);
        marks.add(2);
        marks.add(4);
        System.out.println(marks);
        Collections.sort(marks);
        System.out.println(marks);

        List<Employeee> employees = getEmployees();

        // To enable sorting on a specific field, implement the Comparable interface in your DTO class.
        // Override the compareTo method and define comparison logic based on the desired field.
        System.out.println(employees);
//        Collections.sort(employees);

        Collections.sort(employees, new NameComparator());
        System.out.println(employees);

        Collections.sort(employees, new SalaryComparator());
        System.out.println(employees);

        //Using Java8
        employees.sort(Comparator.comparing(Employeee::getYearOfJoining));
        System.out.println(employees);

    }

    public static List<Employeee> getEmployees() {
        Employeee e1 = new Employeee(1, "Antman", 39, "Male", "DX", 2011, 100000, Arrays.asList("Ruby", "Java", "C++"));
        Employeee e2 = new Employeee(2, "Sam", 24, "Male", "ENG", 2017, 76000, Arrays.asList(".Net", "JavaScript", "C++"));
        Employeee e3 = new Employeee(8, "carol", 30, "Female", "CIS", 2013, 85000, Arrays.asList("Java", "C#", "python"));
        Employeee e4 = new Employeee(3, "Tony", 25, "Male", "HR", 2010, 90000, Arrays.asList("Angular", "Python", "C"));
        Employeee e5 = new Employeee(4, "Hercules", 42, "Male", "DX", 2015, 28000, Arrays.asList("Java", ".Net", "React"));
        Employeee e6 = new Employeee(9, "Bruce", 27, "Male", "CIS", 2020, 68000, Arrays.asList("Java", "JavaScript", "C#"));
        Employeee e7 = new Employeee(6, "Patsy", 28, "Female", "HR", 2022, 30000, Arrays.asList("C++", "Ruby", "Java"));
        Employeee e8 = new Employeee(7, "Natasha", 55, "Female", "HR", 2020, 53000, Arrays.asList("C#", "Python", "C++"));
        Employeee e9 = new Employeee(5, "Wanda", 31, "Female", "ENG", 2023, 25000, Arrays.asList(".Net", "Ruby", "C#"));
        Employeee e10 = new Employeee(10, "Vision", 32, "Gay", "CIS", 2021, 34000, Arrays.asList("Java", ".Net", "C#"));
        Employeee e11 = new Employeee(11, "Wasp", 33, "Female", "DX", 2001, 80070, Arrays.asList("Ruby", "JavaScript", "C++"));
        Employeee e12 = new Employeee(12, "Thor", 34, "Male", "ENG", 2018, 56000, Arrays.asList(".Net", "Java", "C++"));
        Employeee e13 = new Employeee(13, "Thanos", 35, "Male", "CIS", 2019, 67000, Arrays.asList("JavaScript", "C#", "Java"));

        return Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13);
    }
}

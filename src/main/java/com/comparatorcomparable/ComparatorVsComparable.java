package com.comparatorcomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorVsComparable {

    static void main() {

        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(21);
        marks.add(2);
        marks.add(4);
        System.out.println(marks);
        Collections.sort(marks);
        System.out.println(marks);

        List<Employeee> employees = Employeee.getEmployees();

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

}

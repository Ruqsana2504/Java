package com.comparatorcomparable;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employeee> {

    @Override
    public int compare(Employeee o1, Employeee o2) {
        return (int) (o1.getSalary() - o2.getSalary());
    }
}

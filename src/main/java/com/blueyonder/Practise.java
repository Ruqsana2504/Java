package com.blueyonder;

import com.comparatorcomparable.ComparatorVsComparable;
import com.comparatorcomparable.Employeee;

import java.util.*;

public class Practise {

    static void main() {

        List<Employeee> employeesList = ComparatorVsComparable.getEmployees();

        //4th highest salary
        Employeee fourthHighestEmployee = employeesList.stream()
                .sorted(Comparator.comparingDouble(Employeee::getSalary).reversed())
                .distinct()
                .skip(3)
                .limit(1)
                .findFirst()
                .orElseThrow(RuntimeException::new);

        System.out.println("1. FourthHighestEmployee - " + fourthHighestEmployee.getName() + " : " + fourthHighestEmployee.getSalary());

        //4th highest salary - duplicates
        List<Employeee> listOfFourthHighestEmployee = employeesList.stream()
                .filter(emp -> emp.getSalary() == fourthHighestEmployee.getSalary())
                .toList();

        listOfFourthHighestEmployee.forEach(emp -> System.out.print("1.1. FourthHighestEmployee duplicates - " + emp.getName() + " : " + emp.getSalary() + " "));
        System.out.println();

        //010021122 using single for loop.group all 1s and 2 s together
        System.out.println("2. Grouped 0, 1, 2 : " + group012("010021122"));

        //find all strings which contain u and then edit every selected string to [string] this format
        List<String> list = Arrays.asList("sun", "apple", "cup", "dog", "blue");
        System.out.println("3. Modified List : " + modifiedList(list));

        //In an array of positive, negative elements find subarray of atleast one size with sum = 0
        //since this has negative numbers we can't use two pointers
        int[] arr = {4, -3, 1, 2, -3, 4};
        System.out.println("4. Subarray with sum zero : " + hasZeroSumSubarray(arr));
    }

    private static String group012(String str) {
        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '0')
                sb0.append(ch);
            if (ch == '1')
                sb1.append(ch);
            if (ch == '2')
                sb2.append(ch);
        }
        return sb0 + sb1.toString() + sb2;
    }

    private static List<String> modifiedList(List<String> list) {
        return list.stream()
                .filter(str -> str.contains("u"))
                .map(str -> "[" + str + "]")
                .toList();
    }

    private static List<Integer> hasZeroSumSubarray(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = arr.length;
        int prefix = 0;
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < n; i++) {
            prefix += arr[i];
            if (prefix == 0 || hm.containsKey(prefix)) {
                startIndex = hm.get(prefix);
                endIndex = i;
                break;
            }
            hm.put(prefix, i);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = startIndex + 1; i <= endIndex; i++) {
            result.add(arr[i]);
        }

        return result;

//        Gives you true or false if there is a subarray with sum zero
//        HashSet<Integer> hs = new HashSet<>();
//        int n = arr.length;
//        int prefix = 0;
//
//        for (int i = 0; i < n; i++) {
//            prefix += arr[i];
//            if (prefix == 0 || hs.contains(prefix)) {
//                return true;
//            }
//            hs.add(prefix);
//        }
//        return false;

    }

}

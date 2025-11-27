package com.blueyonder;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Interview {

    static void main() {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        Map<Character, Long> characterFrequency = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(characterFrequency);
    }
}

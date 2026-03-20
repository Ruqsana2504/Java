package com.infor;

public class Infor {

    public void m1(int a) {
        System.out.println("From int");
    }

    public void m1(float a) {
        System.out.println("From Float");
    }

    static void main() {
        Infor infor = new Infor();
        infor.m1('a');
        infor.m1(10L);
//        infor.m1(10.2);
    }
}

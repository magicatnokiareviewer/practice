package com.sdabyd2.programowanie;

public class Main {

    public static void main(String[] args) {

        TimeToRemember t1 = new TimeToRemember(10, 56);
        TimeToRemember t2 = new TimeToRemember(0, 123);

        System.out.println("time 1 = " + t1);
        System.out.println("time 2 = " + t2);
        System.out.println("time 1 + time 2 = " + t1.add(t2));
        System.out.println("time 1 - time 2 = " + t1.deduct(t2));
        TimeToRemember[] tab = {t1, t2, t2};

        System.out.println("time 1 * 2 = " + t1.multiply(2));
        System.out.println("Sum up Time for:  t1 + t2 + t2 = " +
                TimeToRemember.sumUp(tab, 3));
        TimeToRemember t3 = new TimeToRemember("3 h 17 min");
        System.out.println("String Constructor: " + t3);
    }
}

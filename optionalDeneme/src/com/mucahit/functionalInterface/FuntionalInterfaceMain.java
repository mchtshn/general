package com.mucahit.functionalInterface;

public class FuntionalInterfaceMain {

    public static void main(String[] args) {
        Add addFuctional1 = ((a, b) -> System.out.println(a + "+" + b + " = " + (a + b)));

        addFuctional1.add(10,12);

        Add addFuctional2= (a, b) -> {
            a=5;
            b=10;
            System.out.println("Burada tanımlanan değerleri aldım ve sonuc "+(a+b));
        };

        addFuctional2.add(20,20);
    }
}

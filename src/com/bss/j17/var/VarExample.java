package com.bss.j17.var;

import java.util.List;

public class VarExample {
    public static void main(String[] args) {
        var message = "Hello, Java 10!";
        var number = 42;
        var list = List.of("Apple", "Banana", "Cherry");

        System.out.println("Message: " + message);
        System.out.println("Number: " + number);
        System.out.println("List: " + list);

    }
}

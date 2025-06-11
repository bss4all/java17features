package com.bss.j17.sealedclass;

sealed class Vehicle permits Car, Bike {
    public void sayHello(){
        System.out.println("Hello from Vehicle!");
    }
}

final class Car extends Vehicle {
    @Override
    public void sayHello() {
        super.sayHello();
        System.out.println("Hello from Car!");
    }
}
final class Bike extends Vehicle {
    @Override
    public void sayHello() {
        super.sayHello();
        System.out.println("Hello from Bike!");
    }
}

public class SealedClassExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Bike();
        vehicle.sayHello();
    }
}

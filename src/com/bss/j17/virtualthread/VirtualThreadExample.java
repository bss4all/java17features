package com.bss.j17.virtualthread;

import java.util.concurrent.Executors;

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(6000); // Pause for 1 second
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class YourThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(6000); // Pause for 1 second
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class VirtualThreadExample {
    public static void main(String[] args) {
        // oldMultiThreadEg();
        var executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++) {
            executor.submit(() -> {
                 System.out.println(Thread.currentThread().getName() + " is running");
            });
            final int taskId = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " - Executing Task " + taskId);
            });
        }
        executor.shutdown();
    }

    private static void oldMultiThreadEg() {
        MyThread t1 = new MyThread();
        YourThread t2 = new YourThread();
        MyThread t3 = new MyThread();
        YourThread t4 = new YourThread();
        MyThread t5 = new MyThread();

        t1.start(); // Start first thread
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start(); // Start second thread
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t3.start();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t4.start();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t5.start();
    }
}

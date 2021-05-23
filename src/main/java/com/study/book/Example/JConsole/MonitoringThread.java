package com.study.book.Example.JConsole;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MonitoringThread {

    public static void createThread() {
        Thread thread = new Thread(() -> {
            while (true) {
            }
        }, "testBusyThread");
        thread.start();
    }

    public static void createLockThread(Object lock) {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws Exception {
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        createThread();
        reader.readLine();
        Object lock = new Object();
        createLockThread(lock);*/
        for (int i = 0; i < 2000; i++) {
            new Thread(new SyncAdd(1,2)).start();
            new Thread(new SyncAdd(2,1)).start();
        }

    }

    static class SyncAdd implements Runnable {
        int a, b;

        public SyncAdd(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }

        }
    }
}

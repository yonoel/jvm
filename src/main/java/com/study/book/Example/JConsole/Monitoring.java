package com.study.book.Example.JConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * VM ARGS:-Xms100M -Xmx100M -XX:+UseSerialGC
 */
public class Monitoring {
    static class OOMObject {
        public byte[] placeHolder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws Exception {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
        System.gc();
        TimeUnit.SECONDS.sleep(60);
    }
}

package com.study.book.Example.allocation;

import java.util.concurrent.TimeUnit;

/**
 * VM ARGS: -verbose:gc -Xmx20M -Xmn10M -XX:+PrintGCDetails --XX:SurvivorRatio=8
 */
public class TestAllocation {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception{

        byte[] ar1, ar2, ar3, ar4;
        ar1 = new byte[2 * _1MB];
        ar2 = new byte[2 * _1MB];
        ar3 = new byte[2 * _1MB];
        ar4 = new byte[2 * _1MB];
        TimeUnit.SECONDS.sleep(500);
    }
}

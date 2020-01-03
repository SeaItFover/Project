package com.codepig.jmm;

import java.util.Random;

/**
 * 堆内存调优
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 */
public class 参数调优 {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        Runtime.getRuntime().maxMemory();

        String str = "I love IT!!!";
        while (true){
            
            str += str +new Random().nextInt(333333333)+new Random().nextInt(6666666);
        }
    }
}

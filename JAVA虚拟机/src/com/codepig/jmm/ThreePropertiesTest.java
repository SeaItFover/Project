package com.codepig.jmm;

/**
 * 三个特性：原子性、可见性、有序性（指令重排）
 */
public class ThreePropertiesTest {
    int a = 0;
    boolean flag = false;

    public void write(){
        a = 1;
        flag = true;
        Thread.interrupted();
    }

    public int read(){
        int i = 0;
        if (flag = true){
             i = a+1;
        }
        return i;
    }

    public static void main(String[] args) {
        ThreePropertiesTest threePropertiesTest = new ThreePropertiesTest();
        new Thread(()->{
            threePropertiesTest.write();
        },"A").start();
        new Thread(()->{
            System.out.println(threePropertiesTest.read());
        },"B").start();
    }
}

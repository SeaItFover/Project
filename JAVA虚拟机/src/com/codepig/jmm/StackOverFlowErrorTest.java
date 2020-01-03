package com.codepig.jmm;

/**
 * 栈内存溢出（栈内存中是方法）
 */
public class StackOverFlowErrorTest {
    public static void A(){
        A();
    }
    public static void main(String[] args) {
        A();
    }
}

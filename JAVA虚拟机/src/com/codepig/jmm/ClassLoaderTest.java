package com.codepig.jmm;

/**
 * 类加载器主要有三种：
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(obj.getClass().getClassLoader());
        //System.out.println(obj.getClass().getClassLoader().getParent());

        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        System.out.println(classLoaderTest.getClass().getClassLoader());
        System.out.println(classLoaderTest.getClass().getClassLoader().getParent());
        System.out.println(classLoaderTest.getClass().getClassLoader().getParent().getParent());

        Thread t1 = new Thread();
        t1.start();
        t1.start();
    }
}

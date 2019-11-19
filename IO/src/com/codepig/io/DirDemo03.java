package com.codepig.io;

import java.io.File;

/**
 *递归：方法自己调用自己
 * 递归头：何时结束递归
 * 递归体：重复调用
 * 打印子孙级文件和目录的名称
 */
public class DirDemo03 {
    public static void main(String[] args) {
        File src = new File("D:/ddd");
        System.out.println(src.getName());
    }

    public static void printName(File src){
        System.out.println(src.getName());
        if (null == src || !src.exists()){
            return;
        }else{
            for (File s:src.listFiles()){
                printName(s);
            }
        }

    }
}
package com.codepig.io.IOstudy_02;

import java.io.*;
import java.util.Random;

public class Test03 {
    public static void main(String[] args) {
        File src = new File("D:\\IDEA\\Project\\IO\\src\\com\\codepig\\io\\IOstudy_02/sll.txt");
        OutputStream os = null;

        try {
            os = new FileOutputStream(src);
            try {
                os.write(-127);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println((char) ((int)(10000*Math.random())));
    }
}

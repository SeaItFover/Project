package com.codepig.io.IOstudy_02;

import java.io.*;
<<<<<<< HEAD
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
=======

public class Test03 {
    public static void main(String[] args) {
        File dest = new File("dest.txt");
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest,false);
            String msg = "IO is too easy";
            byte[] bytes = msg.getBytes();
            os.write(bytes,0,bytes.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

>>>>>>> origin/master
    }
}

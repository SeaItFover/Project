package com.codepig.adavanced;

/**
 * volatile用于保证数据的同步，也就是可见性
 *
 * 这里为什么如果线程体中不写任何代码的话就会导致来不及修改num的值
 * 但是写一句输出语句就会导致修改。
 */
public class VolatileTest {
    private static int num = 0;
    public static void main(String[] args) {
        new Thread(()->{
            while (num == 0){

            }
        }).start();
        /*new Thread(()->{
            while (true){
                if(num == 0){
                    System.out.println(num);
                }else{
                    System.out.println(num);
                }

            }
        }).start();
*/
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        num=1;
    }
}

package com.codepig.gc;

/**
 *finalize中的代码是什么
 *
 */
public class EscapeDeadFinalize {
    public static EscapeDeadFinalize escapeDeadFinalize;

    public static void isAlive(){
        System.out.println("I am still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        escapeDeadFinalize = null;
    }


    public static void main(String[] args) {

        //第一次自救
        escapeDeadFinalize = new EscapeDeadFinalize();
        escapeDeadFinalize = null;
        System.gc();
        if (escapeDeadFinalize == null){
            isAlive();
        }else{
            System.out.println("i am dead!");
        }

        //第二次自救
        escapeDeadFinalize = new EscapeDeadFinalize();
        escapeDeadFinalize = null;
        System.gc();
        if (escapeDeadFinalize == null){
            isAlive();
        }else{
            System.out.println("i am dead!");
        }
    }
}

package com.codepig.adavanced;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 任务调度：Timer类和TimerTest类
 */
public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //timer.schedule(new MyTask(),1000);//执行任务一次
        //timer.schedule(new MyTask(),1000,200);
        Calendar cal = new GregorianCalendar(2019,10,4,13,13,12);
        timer.schedule(new MyTask(),cal.getTime(),200);
    }
}

//任务类
class MyTask extends TimerTask {
    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println("hello world!");
        }
        System.out.println("----end----");
    }
}
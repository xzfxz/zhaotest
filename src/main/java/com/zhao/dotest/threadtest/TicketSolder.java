package com.zhao.dotest.threadtest;

/**
 * Created by zhao on 2016/4/22.
 */

public class TicketSolder {

    public static void main(String[] args) {

//		AtomicInteger totalCount = new AtomicInteger(1000);
        Integer totalCount = new Integer(1000);
        Solder sa = new Solder(totalCount);
        new Thread(sa, "A").start();
        new Thread(sa, "B").start();
        new Thread(sa, "C").start();
    }

}

class Solder implements Runnable {
    Object obj = new Object();
    volatile Integer totalCount;

    public Solder(Integer totalCount) {
        // TODO Auto-generated constructor stub
        this.totalCount = totalCount;
    }


    public void run() {
        // TODO Auto-generated method stub
        //这里条件判断不能用if 容易有虚假唤醒的问题
        while (true) {
            synchronized (obj) {
                if (totalCount > 0) {
                    totalCount --;
                    System.out.println(" sold one " + Thread.currentThread().getName() + " " + totalCount);
                }
            }
        }
    }
}
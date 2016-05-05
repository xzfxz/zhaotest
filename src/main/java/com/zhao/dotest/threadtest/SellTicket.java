package com.zhao.dotest.threadtest;

/**
 * Created by zhao on 2016/4/22.
 */
public class SellTicket implements Runnable {
    private Object obj = new Object();
    private Ticket ticket;

    public SellTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void run() {
        synchronized (obj){
            while (ticket.getTotal()>0){
                ticket.sell();
                System.out.println(Thread.currentThread().getName()+" ticket no: "+ticket.getTotal());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

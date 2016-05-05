package com.zhao.dotest.threadtest;

/**
 * Created by zhao on 2016/4/22.
 */
public class Ticket {
    private int total;

    public Ticket(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void sell(){
        total--;
    }
    public void add(){
        total ++;
        System.out.println("tickets: "+total);
    }

}
